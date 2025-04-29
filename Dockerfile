# syntax=docker/dockerfile:1

# Estágio de construção
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app
COPY src ./src

# Compila todos os arquivos Java
RUN find src -name "*.java" > sources.txt && \
    javac -d out @sources.txt

# Cria o JAR executável
RUN jar cfe app.jar application.Program -C out .  # Substitua pela sua classe principal

# Estágio final de execução
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Cria usuário não privilegiado
RUN adduser --disabled-password --gecos "" appuser && \
    chown -R appuser:appuser /app
USER appuser

# Copia o JAR do estágio de construção
COPY --from=builder --chown=appuser:appuser /app/app.jar .

EXPOSE 8080

CMD ["sh", "-c", "java -cp app.jar ${MAIN_CLASS}"]

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 \
  CMD curl --fail http://localhost:8080/health || exit 1