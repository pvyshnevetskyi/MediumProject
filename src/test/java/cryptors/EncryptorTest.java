package cryptors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptorTest {
    private Encryptor encryptor;

    @BeforeEach
    void setUp() {
        encryptor = new Encryptor();
    }

    @Test
    void shift() {
        assertEquals("!fghij#", encryptor.shift("!abcde#", 5));
        assertEquals("!ABCDE#", encryptor.shift("!VWXYZ#", 5));
    }

    @Test
    void unicode() {
        assertEquals("fghij", encryptor.unicode("abcde", 5));
        assertEquals("{|]~_&", encryptor.unicode("vwXyZ!", 5));
    }

}