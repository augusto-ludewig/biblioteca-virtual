package model.entities;

import java.util.HashMap;
import java.util.Locale;

public class Exemplar {
    private String id; // Identificador único (pode ser gerado automaticamente)
    private Livro livro; // Referência ao livro original
    private Status status;

    public Exemplar(Livro livro) {
        this.livro = livro;
        this.status = Status.DISPONIVEL;
        this.id = gerarIdUnico(); // Implemente sua lógica de ID (ex: UUID)
    }

    private String gerarIdUnico() {
        // Combinação do primeiro nome do livro + número sequencial
        String x = livro.getTitulo().toLowerCase(Locale.ROOT);
        int inicio = x.indexOf(0);
        int fim = x.indexOf(" ");
        return x.substring(inicio + 1, fim) + livro.consultarExemplares().size() + 1;
    }

    // Getters e setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Status: " + status;
    }
}