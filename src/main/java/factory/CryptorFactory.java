package factory;


import cryptors.Cryptor;
import cryptors.Decryptor;
import cryptors.Encryptor;

public class CryptorFactory {

    public static Cryptor getCryptor(String type) {
        if (type.equals("dec")) {
            return new Decryptor();
        }
        return new Encryptor();
    }
}