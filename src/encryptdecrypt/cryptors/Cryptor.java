package encryptdecrypt.cryptors;

public abstract class Cryptor {
    public abstract String shift(String message, int key);

    public abstract String unicode(String message, int key);
}