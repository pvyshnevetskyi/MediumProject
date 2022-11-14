package cryptors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptorTest {
    private static Decryptor decryptor;

    @BeforeAll
    static void setUp() {
        decryptor = new Decryptor();
    }

    @Test
    void shift() {
        assertEquals("!abcde#", decryptor.shift("!fghij#", 5));
        assertEquals("!VWXYZ#", decryptor.shift("!ABCDE#", 5));
    }

    @Test
    void unicode() {
        assertEquals("abcde", decryptor.unicode("fghij", 5));
        assertEquals("vwXyZ!", decryptor.unicode("{|]~_&", 5));
    }
}