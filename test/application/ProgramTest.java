package test.application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes para o método myMethod da classe Program.
 */
public class ProgramTest {

    // Valores de teste em constantes para evitar magic numbers
    private static final int INPUT_VALUE = 5;
    private static final int EXPECTED_OUTPUT = 10;

    @Test
    void testMyMethod() {
        Program program = new Program();
        int actualOutput = program.myMethod(INPUT_VALUE);
        assertEquals(EXPECTED_OUTPUT, actualOutput, "O resultado deve ser " + EXPECTED_OUTPUT);
    }
}

// Classe a ser testada
class Program {

    /**
     * Dobra o valor de entrada.
     *
     * @param input valor de entrada
     * @return o dobro de {@code input}
     */
    public int myMethod(final int input) {
        return input * 2;
    }
}
