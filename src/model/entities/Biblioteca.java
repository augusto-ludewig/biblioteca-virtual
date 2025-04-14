package model.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** Representa uma biblioteca com uma lista de livros. */
public final class Biblioteca {
  private final ArrayList<Livro> listaDeLivros;

  public ArrayList<Livro> getListaDeLivros() {
    return listaDeLivros;
  }

  public Biblioteca() {
    this.listaDeLivros = new ArrayList<Livro>();
  }

  public void adicionarLivro(final Livro livro) {
    if (livro == null) {
      throw new IllegalArgumentException("O livro não pode ser nulo");
    }
    this.listaDeLivros.add(livro);
  }

  public void adicionarListaDeLivros(List<Livro> livro) {
    if (livro == null) {
      throw new IllegalArgumentException("A lista de livros não pode ser nulo");
    }
    for (Livro l : livro) {
        this.listaDeLivros.add(l);
    }
  }

  public void removerLivro(final Livro livro) {
    listaDeLivros.remove(livro);
  }

  public Livro consultarLivro(int index){
    return listaDeLivros.get(index);
  }

  public void listarLivros() {
    int indice = 1;
    for (Livro livro : listaDeLivros) {
      System.out.println(indice + " - " + livro);
      indice++;
    }
  }

  public List<Exemplar> getExemplaresDoLivro(String tituloLivro) {
    for (Livro livro : listaDeLivros) {
      if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
        return livro.consultarExemplares(); // Retorna a lista de exemplares do livro
      }
    }
    return new ArrayList<>(); // Livro não encontrado → retorna lista vazia
  }


}
