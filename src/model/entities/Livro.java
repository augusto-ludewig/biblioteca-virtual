package model.entities;

/**
 * Classe que representa um livro.
 */
public final class Livro {
  /** Título do livro. */
  private String titulo;

  /** Autor do livro. */
  private String autor;

  /** Ano de publicação. */
  private Integer anoPublicacao;


  /**
   * Construtor do livro.
   */
  public Livro(final String novoTitulo, final String novoAutor, final Integer novoAnoPublicacao) {
    this.titulo = novoTitulo;
    this.autor = novoAutor;
    this.anoPublicacao = novoAnoPublicacao;
  }

  /**
   * Define o título do livro.
   *
   * @param novoTitulo Novo título
   */
  public void setTitulo(final String novoTitulo) {
    this.titulo = novoTitulo;
  }

  /**
   * Define o autor do livro.
   *
   * @param novoAutor Novo autor
   */
  public void setAutor(final String novoAutor) {
    this.autor = novoAutor;
  }

  /**
   * Define o ano de publicação do livro.
   *
   * @param novoAnoPublicacao Novo ano de publicação
   */
  public void setAnoPublicacao(final Integer novoAnoPublicacao) {
    this.anoPublicacao = novoAnoPublicacao;
  }

  /**
   * Retorna os dados do livro em formato de string.
   *
   * @return String formatada com os dados do livro
   */
  @Override
  public String toString() {
    return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao
        + "]";
  }
}
