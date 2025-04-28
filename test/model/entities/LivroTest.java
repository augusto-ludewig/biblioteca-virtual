package model.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LivroTest {

    private Livro livro;

    @BeforeEach
    void setUp() {
        livro = new Livro(
                "Clean Code",
                "Robert C. Martin",
                "Programação",
                2008,
                3
        );
    }

    // CHECKSTYLE:OFF: MagicNumber
    // Testes de Construção e Getters
    @Test
    void testConstrutorComExemplares() {
        assertEquals("Clean Code", livro.getTitulo());
        assertEquals(2008, livro.getAnoPublicacao());
        assertEquals(3, livro.consultarExemplares().size());
    }

    @Test
    void testAdicionarExemplar() {
        int exemplaresIniciais = livro.consultarExemplares().size();
        livro.adicionarExemplar();
        assertEquals(exemplaresIniciais + 1, livro.consultarExemplares().size());
    }

    // Testes de Empréstimo/Devolução
    @Test
    void testEmprestarExemplarDisponivel() {
        Exemplar exemplar = livro.emprestarExemplar();
        assertNotNull(exemplar);
        assertEquals(Status.EMPRESTADO, exemplar.getStatus());
    }

    @Test
    void testEmprestarSemExemplaresDisponiveis() {
        // Empresta todos os exemplares
        livro.emprestarExemplar();
        livro.emprestarExemplar();
        livro.emprestarExemplar();

        assertNull(livro.emprestarExemplar());
    }

    @Test
    void testDevolverExemplar() {
        Exemplar exemplar = livro.emprestarExemplar();
        livro.devolverExemplar(exemplar);
        assertEquals(Status.DISPONIVEL, exemplar.getStatus());
    }

    // Testes de Consultas
    @Test
    void testGetExemplaresDisponiveis() {
        livro.emprestarExemplar(); // Empresta 1
        List<Exemplar> disponiveis = livro.getExemplaresDisponiveis();
        assertEquals(2, disponiveis.size());
        disponiveis.forEach(e ->
                assertEquals(Status.DISPONIVEL, e.getStatus())
        );
    }

    @Test
    void testGetExemplaresEmprestados() {
        livro.emprestarExemplar();
        livro.emprestarExemplar();
        assertEquals(2, livro.getExemplaresEmprestados().size());
    }

    // Testes de Igualdade e Comparação
    @Test
    void testEqualsCaseInsensitive() {
        Livro livro2 = new Livro(
                "clean CODE", // Título diferente em caixa
                "Autor",
                "Gênero",
                2020,
                1
        );
        assertTrue(livro.equals(livro2));
    }

    @Test
    void testCompareTo() {
        Livro livroA = new Livro("Aprendendo Java", "...", "...", 2020, 1);
        Livro livroB = new Livro("ZooKeeper Essentials", "...", "...", 2020, 1);
        assertTrue(livroA.compareTo(livroB) < 0);
    }

    // Testes de Estado Inicial
    @Test
    void testNovoLivroSemExemplares() {
        Livro novoLivro = new Livro(); // Construtor padrão
        assertEquals(0, novoLivro.consultarExemplares().size());
    }

    // Testes de Setters
    @Test
    void testSetAnoPublicacao() {
        livro.setAnoPublicacao(2023);
        assertEquals(2023, livro.getAnoPublicacao());
    }

    @Test
    void testSetGeneroLiterario() {
        livro.setGeneroLiterario("TI");
        assertEquals("TI", livro.getGeneroLiterario());
    }
    // CHECKSTYLE:ON: MagicNumber
}
