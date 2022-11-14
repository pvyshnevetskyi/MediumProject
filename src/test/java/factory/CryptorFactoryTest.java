package factory;

import cryptors.Decryptor;
import cryptors.Encryptor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptorFactoryTest {

    @Test
    void getCryptor() {
        assertEquals(Encryptor.class, CryptorFactory.getCryptor("enc").getClass());
        assertEquals(Decryptor.class, CryptorFactory.getCryptor("dec").getClass());
    }
}