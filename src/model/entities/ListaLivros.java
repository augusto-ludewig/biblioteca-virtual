package model.entities;

import java.util.LinkedList;

// Representa uma lista de livro

public class ListaLivros {

  private final LinkedList<Livro> listaLivros;

  public ListaLivros() {
    this.listaLivros = new LinkedList<Livro>();
  }

  /**
   * Adiciona um livro à lista.
   * 
   * @param livro Livro a ser adicionado (não pode ser nulo)
   * @throws IllegalArgumentException Se o livro for nulo
   */
  public final void adicionarLivro(final Livro livro) { // Final e parâmetro final
    if (livro == null) {
      throw new IllegalArgumentException("Livro não pode ser nulo");
    }
    this.listaLivros.add(livro);
  }

  // Remove um livro da lista
  public void removerLivro(final Livro livro) {
    listaLivros.remove(livro);
  }

  // Lista todos os livros
  public void listarLivros() {
    for (Livro elemento : listaLivros) {
      System.out.println(elemento);
    }
  }

}
