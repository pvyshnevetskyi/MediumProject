package encryptdecrypt.cryptors;

public class Encryptor extends Cryptor {

    public String shift(String message, int key) {
        StringBuilder sb = new StringBuilder();
        char character;
        for (int i = 0; i < message.length(); i++) {
            character = message.charAt(i);
            if (character >= 'a' && character <= 'z') {
                sb.append((character + key) <= 'z' ?
                        (char) (character + key) : (char) (character + key - 26));
            } else if (character >= 'A' && character <= 'Z') {
                sb.append((character + key) <= 'Z' ?
                        (char) (character + key) : (char) (character + key - 26));
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public String unicode(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append((char) (message.charAt(i) + key));
        }
        return sb.toString();
    }
}