package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma biblioteca com uma lista de livros.
 */
public final class Biblioteca {
    /**
     * Lista de livros da biblioteca.
     */
    private final ArrayList<Livro> listaDeLivros;

    /**
     * Retorna a lista de livros da biblioteca.
     *
     * @return Lista de livros
     */
    public ArrayList<Livro> getListaDeLivros() {
        return listaDeLivros;
    }

    /**
     * Constrói uma nova biblioteca com lista de livros vazia.
     */
    public Biblioteca() {
        this.listaDeLivros = new ArrayList<>();
    }

    /**
     * Adiciona um livro à biblioteca.
     *
     * @param livro Livro a ser adicionado
     * @throws IllegalArgumentException Se o livro for nulo
     */
    public void adicionarLivro(final Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O livro não pode ser nulo");
        }
        this.listaDeLivros.add(livro);
    }

    /**
     * Adiciona uma lista de livros à biblioteca.
     *
     * @param livros Lista de livros a serem adicionados
     * @throws IllegalArgumentException Se a lista for nula
     */
    public void adicionarListaDeLivros(final List<Livro> livros) {
        if (livros == null) {
            throw new IllegalArgumentException("A lista de livros não pode ser nula");
        }
        for (Livro livro : livros) {
            this.listaDeLivros.add(livro);
        }
    }

    /**
     * Remove um livro da biblioteca.
     *
     * @param livro Livro a ser removido
     */
    public void removerLivro(final Livro livro) {
        listaDeLivros.remove(livro);
    }

    /**
     * Consulta um livro pelo índice.
     *
     * @param index Índice do livro na lista
     * @return Livro correspondente ao índice
     */
    public Livro consultarLivro(final int index) {
        return listaDeLivros.get(index);
    }

    /**
     * Lista todos os livros da biblioteca no console.
     */
    public void listarLivros() {
        int indice = 1;
        for (Livro livro : listaDeLivros) {
            System.out.println(indice + " - " + livro);
            indice++;
        }
    }

    /**
     * Obtém os exemplares de um livro pelo título.
     *
     * @param tituloLivro Título do livro a ser pesquisado
     * @return Lista de exemplares do livro encontrado ou lista vazia se não encontrado
     */
    public List<Exemplar> getExemplaresDoLivro(final String tituloLivro) {
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                return livro.consultarExemplares();
            }
        }
        return new ArrayList<>();
    }
}
