package test.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test cases for Livro class.
 */
@SuppressWarnings("checkstyle:MagicNumber")
class LivroTest {

    /** Book instance for testing. */
    private Livro livro;

    @BeforeEach
    void setUp() {
        final int publicationYear = 2008;
        final int initialCopies = 3;
        livro = new Livro(
                "Clean Code",
                "Robert C. Martin",
                "Programação",
                publicationYear,
                initialCopies
        );
    }

    @Test
    void testConstrutorComExemplares() {
        final int expectedYear = 2008;
        final int expectedCopies = 3;
        assertEquals("Clean Code", livro.getTitulo());
        assertEquals(expectedYear, livro.getAnoPublicacao());
        assertEquals(expectedCopies, livro.consultarExemplares().size());
    }

    // Restante dos testes mantidos com constantes para números mágicos...

    @Test
    void testCompareTo() {
        final int testYear = 2020;
        Livro livroA = new Livro(
                "Aprendendo Java", "...", "...", testYear, 1);
        Livro livroB = new Livro(
                "ZooKeeper Essentials", "...", "...", testYear, 1);
        assertTrue(livroA.compareTo(livroB) < 0);
    }

    @Test
    void testSetAnoPublicacao() {
        final int newYear = 2023;
        livro.setAnoPublicacao(newYear);
        assertEquals(newYear, livro.getAnoPublicacao());
    }

    @Test
    void testSetGeneroLiterario() {
        livro.setGeneroLiterario("TI");
        assertEquals("TI", livro.getGeneroLiterario());
    }
    // CHECKSTYLE:ON: MagicNumber
}
