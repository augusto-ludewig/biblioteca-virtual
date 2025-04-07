package model.entities;

// Classe que representa um livro com título, autor e ano de publicação.

public final class Livro {

  private String titulo;
  private String autor;
  private Integer anoPublicacao;

  /**
   * Construtor do livro.
   * 
   * @param novoTitulo Título do livro
   * @param novoAutor Autor do livro
   * @param novoAnoPublicacao Ano de publicação
   */

  public Livro(final String titulo, final String autor, final Integer anoPublicacao) {
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
  }


  /**
   * Retorna o título do livro.
   * 
   * @return Título atual do livro
   */
  public String getTitulo() {
    return titulo;
  }


  public void setTitulo(final String titulo) {
    this.titulo = titulo;
  }

  /**
   * Retorna o autor do livro.
   * 
   * @return autor atual do livro
   */
  public String getAutor() {
    return autor;
  }

  public void setAutor(final String autor) {
    this.autor = autor;
  }

  /**
   * Retorna o ano de publicação do livro.
   * 
   * @return ano de publicação do livro
   */
  public Integer getAnoPublicacao() {
    return anoPublicacao;
  }

  public void setAnoPublicacao(final Integer anoPublicacao) {
    this.anoPublicacao = anoPublicacao;
  }

  // retorna os dados do livro em uma String
  @Override
  public String toString() {
    return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao
        + "]";
  }



}
