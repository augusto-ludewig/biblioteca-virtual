package model.entities;

import com.sun.xml.internal.ws.util.VersionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Classe que representa um livro. */
public final class Livro implements Comparable<Livro> {
  private String titulo;
  private String autor;
  private String generoLiterario;
  private int anoPublicacao;
  private List<Exemplar> exemplares; // Lista de unidades físicas;

  public Livro(){}

  public Livro(
      final String novoTitulo,
      final String novoAutor,
      final String novoGeneroLiterario,
      final int novoAnoPublicacao,
      int quantidadeExemplares) {
    this.titulo = novoTitulo;
    this.autor = novoAutor;
    this.generoLiterario = novoGeneroLiterario;
    this.anoPublicacao = novoAnoPublicacao;
    this.exemplares = new ArrayList<>();

    for (int i = 0; i < quantidadeExemplares; i++){
      adicionarExemplar();
    }
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getGeneroLiterario() {
    return generoLiterario;
  }

  public int getAnoPublicacao() {
    return anoPublicacao;
  }

  public void setTitulo(final String novoTitulo) {
    this.titulo = novoTitulo;
  }

  public void setAutor(final String novoAutor) {
    this.autor = novoAutor;
  }

  public void setGeneroLiterario(final String novoGeneroLiterario) {
    this.generoLiterario = novoGeneroLiterario;
  }

  public void setAnoPublicacao(final Integer novoAnoPublicacao) {
    this.anoPublicacao = novoAnoPublicacao;
  }

  // Adiciona um novo exemplar ao livro
  public void adicionarExemplar() {
    Exemplar exemplar = new Exemplar(this);
    exemplares.add(exemplar);
  }

  // Empresta um exemplar disponível (retorna null se não houver)
  public Exemplar emprestarExemplar() {
    for (Exemplar exemplar : exemplares) {
      if (exemplar.getStatus() == Status.DISPONIVEL) {
        exemplar.setStatus(Status.EMPRESTADO);
        return exemplar;
      }
    }
    return null; // Nenhum exemplar disponível
  }

  // Devolve um exemplar
  public void devolverExemplar(Exemplar exemplar) {
    if (exemplares.contains(exemplar)) {
      exemplar.setStatus(Status.DISPONIVEL);
    }
  }

  public List<Exemplar> consultarExemplares() {
    return exemplares.stream().collect(Collectors.toList());
  }

  public List<Exemplar> getExemplaresDisponiveis() {
    return exemplares.stream()
            .filter(e -> e.getStatus() == Status.DISPONIVEL)
            .collect(Collectors.toList());
  }

  public List<Exemplar> getExemplaresEmprestados() {
    return exemplares.stream()
            .filter(e -> e.getStatus() == Status.EMPRESTADO)
            .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return titulo;
  }

  public String toStringDetalhado() {
    return titulo
            + ", autor:" + autor
            + ", gênero:" + generoLiterario
            + ", publicação: " + anoPublicacao
            + ", exemplares: " + exemplares;
  }

  @Override
  public int compareTo(Livro outroLivro) {
    return this.titulo.compareTo(outroLivro.titulo);
  }

  //Para facilitar a simulação e o código principal ficar clean, esse método cria 10 livros
  public static void criarLivros(Biblioteca b){

    // Livros de Aventura
    b.adicionarLivro(new Livro("Harry Potter e o Cálice de Fogo", "J. K. Rowling", "Aventura", 2000, 1));
    b.adicionarLivro(new Livro("Jogos Vorazes", "Suzanne Collins", "Aventura", 2008, 2));
    b.adicionarLivro(new Livro("Maze Runner - Correr ou Morrer", "James Dashner", "Aventura", 2009, 3));

    // Livros de Programação
    b.adicionarLivro(new Livro("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", "Programação", 2008, 1));
    b.adicionarLivro(new Livro("Código Limpo: Habilidades Práticas do Agile Software", "Robert C. Martin", "Programação", 2009, 1));
    b.adicionarLivro(new Livro("Algoritmos: Teoria e Prática", "Thomas H. Cormen", "Programação", 1990, 2));
    b.adicionarLivro(new Livro("Effective Java", "Joshua Bloch", "Programação", 2001, 1));
    b.adicionarLivro(new Livro("Introdução à Programação com Python", "Nilo Ney Coutinho Menezes", "Programação", 2019, 1));

    // Livros de Matemática/Ciência
    b.adicionarLivro(new Livro("O Homem que Calculava", "Malba Tahan", "Matemática", 1949, 1));
    b.adicionarLivro(new Livro("O Andar do Bêbado: Como o Acaso Determina Nossas Vidas", "Leonard Mlodinow", "Ciência", 2008, 1));
  }


}
