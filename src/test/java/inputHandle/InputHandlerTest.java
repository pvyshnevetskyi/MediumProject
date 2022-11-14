package inputHandle;

import cryptors.Encryptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
    private static InputHandler inputHandler;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    static void setUp() {
        inputHandler = new InputHandler();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @BeforeEach
    void beforeEach() {
        inputHandler.handleInput(new String[]{"-data", "abcde",
                "-key", "5",
                "-alg", "unicode",
                "-in", "testIn.txt",
                "-out", "testOut.txt",
                "-mode", "enc"});
    }

    @Test
    void handleInput() {
    }

    @Test
    void crypt() throws FileNotFoundException {
        inputHandler.crypt();
        Scanner scanner = new Scanner(new File("testOut.txt"));
        assertEquals("fghij", scanner.nextLine());
    }

    @Test
    void readFromFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("testIn.txt"));
        bufferedWriter.write("testString");
        bufferedWriter.close();

        inputHandler.readFromFile();

        assertEquals("testString", inputHandler.getData());
    }

    @Test
    void cryptInConsole() {
        inputHandler.cryptInConsole(new Encryptor());
        assertEquals("fghij", outputStreamCaptor.toString().trim());
    }

    @Test
    void cryptInFile() throws FileNotFoundException {
        inputHandler.cryptInFile(new Encryptor());
        Scanner scanner = new Scanner(new File("testOut.txt"));
        assertEquals("fghij", scanner.nextLine());
    }
}