package model.entities;

import java.util.ArrayList;
import java.util.LinkedList;

/** Representa uma biblioteca com uma lista de livros. */
public final class Biblioteca {
  private final ArrayList<Livro> listaDeLivros;

  public ArrayList<Livro> getListaDeLivros() {
    return listaDeLivros;
  }

  public Biblioteca() {
    this.listaDeLivros = new ArrayList<>();
  }

  public void adicionarLivro(final Livro livro) {
    if (livro == null) {
      throw new IllegalArgumentException("O livro não pode ser nulo");
    }
    this.listaDeLivros.add(livro);
  }

  public void removerLivro(final Livro livro) {
    listaDeLivros.remove(livro);
  }

  public Livro consultarLivro(int index){
    return listaDeLivros.get(index);
  }

  public void listarLivros() {
    int indice = 1; // Começa em 1 para ficar mais amigável
    for (Livro livro : listaDeLivros) {
      System.out.println(indice + " - " + livro); // Formato: "1 - [dados do livro]"
      indice++;
    }
  }
}
