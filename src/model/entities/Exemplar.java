package model.entities;

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
        // Exemplo: Combinação do nome do livro + número sequencial
        return livro.getTitulo() + "-" + (livro.getExemplaresDisponiveis().size() + 1);
    }

    // Getters e setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}