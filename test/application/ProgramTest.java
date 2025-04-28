package test.application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {

    @Test
    void testMyMethod() {
        MyClass myClass = new MyClass();
        int input = 5;
        int expectedOutput = 10;

        // Chamar o método
        int actualOutput = myClass.myMethod(input);

        // Verificar o resultado
        assertEquals(expectedOutput, actualOutput, "O resultado deve ser 10");
    }
}

// Classe a ser testada
class Program {
    public int myMethod(int input) {
        return input * 2;
    }
}