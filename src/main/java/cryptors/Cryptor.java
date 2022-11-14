package cryptors;

public interface Cryptor {
    String shift(String message, int key);

    String unicode(String message, int key);
}