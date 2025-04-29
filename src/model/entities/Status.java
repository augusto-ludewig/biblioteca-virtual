package model.entities;

/**
 * Representa o status de um exemplar de livro na biblioteca.
 */
public enum Status {

    /**
     * Exemplar disponível para empréstimo.
     */
    DISPONIVEL,

    /**
     * Exemplar atualmente emprestado a um usuário.
     */
    EMPRESTADO,

    /**
     * Exemplar reservado por um usuário, aguardando retirada.
     */
    RESERVADO
}
