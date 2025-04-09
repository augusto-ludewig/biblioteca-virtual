package model.entities;

import java.util.LinkedList;

/** Representa uma lista de livros. */
public final class ListaLivros {
  private final LinkedList<Livro> listaLivros;

  public ListaLivros() {
    this.listaLivros = new LinkedList<Livro>();
  }

  public void adicionarLivro(final Livro livro) {
    if (livro == null) {
      throw new IllegalArgumentException("O livro não pode ser nulo");
    }
    this.listaLivros.add(livro);
  }

  public void removerLivro(final Livro livro) {
    listaLivros.remove(livro);
  }

  public void listarLivros() {
    for (Livro elemento : listaLivros) {
      System.out.println(elemento);
    }
  }
}
