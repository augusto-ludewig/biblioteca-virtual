package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Representa um livro com título, autor, gênero, ano de publicação e exemplares.
 */
public final class Livro implements Comparable<Livro> {

    /**
     * Título do livro.
     */
    private String titulo;

    /**
     * Autor do livro.
     */
    private String autor;

    /**
     * Gênero literário do livro.
     */
    private String generoLiterario;

    /**
     * Ano de publicação do livro.
     */
    private int anoPublicacao;

    /**
     * Lista de exemplares físicos disponíveis.
     */
    private final List<Exemplar> exemplares;

    /**
     * Construtor padrão.
     */
    public Livro() {
        this.exemplares = new ArrayList<>();
    }

    /**
     * Constrói um novo livro e cria exemplares.
     *
     * @param novoTitulo           título do livro
     * @param novoAutor            autor do livro
     * @param novoGeneroLiterario  gênero literário
     * @param novoAnoPublicacao    ano de publicação
     * @param quantidadeExemplares número de exemplares iniciais
     */
    public Livro(
            final String novoTitulo,
            final String novoAutor,
            final String novoGeneroLiterario,
            final int novoAnoPublicacao,
            final int quantidadeExemplares
    ) {
        this.titulo = novoTitulo;
        this.autor = novoAutor;
        this.generoLiterario = novoGeneroLiterario;
        this.anoPublicacao = novoAnoPublicacao;
        this.exemplares = new ArrayList<>();

        for (int i = 0; i < quantidadeExemplares; i++) {
            adicionarExemplar();
        }
    }

    /**
     * @return título do livro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return autor do livro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @return gênero literário
     */
    public String getGeneroLiterario() {
        return generoLiterario;
    }

    /**
     * @return ano de publicação
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * Define um novo título para o livro.
     *
     * @param novoTitulo título a ser definido
     */
    public void setTitulo(final String novoTitulo) {
        this.titulo = novoTitulo;
    }

    /**
     * Define um novo autor para o livro.
     *
     * @param novoAutor autor a ser definido
     */
    public void setAutor(final String novoAutor) {
        this.autor = novoAutor;
    }

    /**
     * Define um novo gênero literário para o livro.
     *
     * @param novoGenero novo gênero a ser definido
     */
    public void setGeneroLiterario(final String novoGenero) {
        this.generoLiterario = novoGenero;
    }

    /**
     * Define um novo ano de publicação.
     *
     * @param novoAnoPublicacao ano a ser definido
     */
    public void setAnoPublicacao(final Integer novoAnoPublicacao) {
        this.anoPublicacao = novoAnoPublicacao;
    }

    /**
     * Adiciona um exemplar ao livro.
     */
    public void adicionarExemplar() {
        Exemplar exemplar = new Exemplar(this);
        exemplares.add(exemplar);
    }

    /**
     * Empréstimo de um exemplar disponível.
     *
     * @return exemplar emprestado ou null se indisponível
     */
    public Exemplar emprestarExemplar() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getStatus() == Status.DISPONIVEL) {
                exemplar.setStatus(Status.EMPRESTADO);
                return exemplar;
            }
        }
        return null;
    }

    /**
     * Devolve um exemplar ao acervo.
     *
     * @param exemplar exemplar a ser devolvido
     */
    public void devolverExemplar(final Exemplar exemplar) {
        if (exemplares.contains(exemplar)) {
            exemplar.setStatus(Status.DISPONIVEL);
        }
    }

    /**
     * Consulta todos os exemplares.
     *
     * @return cópia da lista de exemplares
     */
    public List<Exemplar> consultarExemplares() {
        return new ArrayList<>(exemplares);
    }

    /**
     * @return lista de exemplares disponíveis
     */
    public List<Exemplar> getExemplaresDisponiveis() {
        return exemplares.stream()
                .filter(e -> e.getStatus() == Status.DISPONIVEL)
                .collect(Collectors.toList());
    }

    /**
     * @return lista de exemplares emprestados
     */
    public List<Exemplar> getExemplaresEmprestados() {
        return exemplares.stream()
                .filter(e -> e.getStatus() == Status.EMPRESTADO)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return titulo;
    }

    /**
     * Retorna representação detalhada do livro.
     *
     * @return string com detalhes do livro e exemplares
     */
    public String toStringDetalhado() {
        return titulo
                + ", autor:" + autor
                + ", gênero:" + generoLiterario
                + ", publicação:" + anoPublicacao
                + ", exemplares:\n" + exemplares;
    }

    @Override
    public int compareTo(final Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    }

    /**
     * Gera uma lista de livros de exemplo na biblioteca.
     *
     * @param biblioteca repositório para adicionar livros
     */
    public void criarLivros(final Biblioteca biblioteca) {
        // Aventura
        biblioteca.adicionarLivro(
                new Livro(
                        "Harry Potter e o Cálice de Fogo",
                        "J. K. Rowling",
                        "Aventura",
                        2000,
                        1
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "Jogos Vorazes",
                        "Suzanne Collins",
                        "Aventura",
                        2008,
                        2
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "Maze Runner - Correr ou Morrer",
                        "James Dashner",
                        "Aventura",
                        2009,
                        3
                )
        );
        // Programação
        biblioteca.adicionarLivro(
                new Livro(
                        "Clean Code: A Handbook of Agile Software Craftsmanship",
                        "Robert C. Martin",
                        "Programação",
                        2008,
                        1
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "Código Limpo: Habilidades Práticas do Agile Software",
                        "Robert C. Martin",
                        "Programação",
                        2009,
                        1
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "Algoritmos: Teoria e Prática",
                        "Thomas H. Cormen",
                        "Programação",
                        1990,
                        2
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "Effective Java",
                        "Joshua Bloch",
                        "Programação",
                        2001,
                        1
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "Introdução à Programação com Python",
                        "Nilo Ney Coutinho Menezes",
                        "Programação",
                        2019,
                        1
                )
        );
        // Matemática/Ciência
        biblioteca.adicionarLivro(
                new Livro(
                        "O Homem que Calculava",
                        "Malba Tahan",
                        "Matemática",
                        1949,
                        1
                )
        );
        biblioteca.adicionarLivro(
                new Livro(
                        "O Andar do Bêbado: Como o Acaso Determina Nossas Vidas",
                        "Leonard Mlodinow",
                        "Ciência",
                        2008,
                        1
                )
        );
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Livro)) {
            return false;
        }
        Livro livro = (Livro) o;
        return titulo.equalsIgnoreCase(livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase());
    }
}
