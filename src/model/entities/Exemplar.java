package model.entities;

import java.util.Locale;

/**
 * Representa um exemplar físico de um livro na biblioteca.
 */
public final class Exemplar {
    /** Identificador único do exemplar. */
    private String id;

    /** Livro ao qual este exemplar pertence. */
    private Livro livro;

    /** Status atual do exemplar. */
    private Status status;

    /**
     * Constrói um exemplar associado a um livro específico.
     *
     * @param livroParam Livro ao qual o exemplar pertence
     */
    public Exemplar(final Livro livroParam) {
        this.livro = livroParam;
        this.status = Status.DISPONIVEL;
        this.id = gerarIdUnico();
    }

    private String gerarIdUnico() {
        String x = livro.getTitulo().toLowerCase(Locale.ROOT);
        int inicio = x.indexOf(0);
        int fim = x.indexOf(" ");
        return x.substring(inicio + 1, fim) + livro.consultarExemplares().size() + 1;
    }

    /**
     * Retorna o status atual do exemplar.
     *
     * @return Status do exemplar
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Define o status do exemplar.
     *
     * @param status Novo status do exemplar
     */
    public void setStatus(final Status status) {
        this.status = status;
    }

    /**
     * Retorna o ID único do exemplar.
     *
     * @return ID do exemplar
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID único do exemplar.
     *
     * @param id Novo ID do exemplar
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Retorna o livro associado ao exemplar.
     *
     * @return Livro do exemplar
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * Define o livro associado ao exemplar.
     *
     * @param livroParam Novo livro do exemplar
     */
    public void setLivro(final Livro livroParam) {
        this.livro = livroParam;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " - Status: " + status;
    }
}