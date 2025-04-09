package model.entities;

import com.sun.xml.internal.ws.util.VersionUtil;

/** Classe que representa um livro. */
public final class Livro implements Comparable<Livro> {

  /** Título do livro. */
  private String titulo;

  /** Autor do livro. */
  private String autor;

  /** Ano de publicação do livro. */
  private int anoPublicacao;

  /** Unidades disponíveis do livro. */
  private int disponibilidade;

  /**
   * Construtor do livro.
   *
   * @param novoTitulo Título do livro (não pode ser nulo)
   * @param novoAutor Autor do livro (não pode ser nulo)
   * @param novoAnoPublicacao Ano de publicação (deve ser um valor válido)
   * @param novaDisponibilidade Unidades disponíveis do livro (não pode ser nulo)
   */
  public Livro(
      final String novoTitulo, // 4 espaços de indentação
      final String novoAutor,
      final int novoAnoPublicacao,
      final int novaDisponibilidade) {
    this.titulo = novoTitulo;
    this.autor = novoAutor;
    this.anoPublicacao = novoAnoPublicacao;
    this.disponibilidade = novaDisponibilidade;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public int getAnoPublicacao() {
    return anoPublicacao;
  }

  public int getDisponibilidade() {
    return disponibilidade;
  }

  public void setTitulo(final String novoTitulo) {
    this.titulo = novoTitulo;
  }

  public void setAutor(final String novoAutor) {
    this.autor = novoAutor;
  }

  public void setAnoPublicacao(final Integer novoAnoPublicacao) {
    this.anoPublicacao = novoAnoPublicacao;
  }

  public void setDisponibilidade(int disponibilidade) {
    this.disponibilidade = disponibilidade;
  }

  @Override
  public String toString() {
    return "Livro [titulo=" + titulo
        + ", autor=" + autor
        + ", anoPublicacao=" + anoPublicacao
        + ", unidades disponíveis=" + disponibilidade
        + "]";
  }

  @Override
  public int compareTo(Livro outroLivro) {
    return this.titulo.compareTo(outroLivro.titulo);
  }
}
