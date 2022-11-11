package encryptdecrypt.factory;

import encryptdecrypt.cryptors.Cryptor;
import encryptdecrypt.cryptors.Decryptor;
import encryptdecrypt.cryptors.Encryptor;

public class CryptorFactory {

    public static Cryptor getCryptor(String type) {
        if (type.equals("dec")) {
            return new Decryptor();
        }
        return new Encryptor();
    }
}