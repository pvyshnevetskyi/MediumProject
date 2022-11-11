package cryptors;

public class Decryptor extends Cryptor {

    public String shift(String message, int key) {
        StringBuilder sb = new StringBuilder();
        char character;
        for (int i = 0; i < message.length(); i++) {
            character = message.charAt(i);
            if (character >= 'a' && character <= 'z') {
                sb.append((character - key) >= 'a' ?
                        (char) (character - key) : (char) (character - key + 26));
            } else if (character >= 'A' && character <= 'Z') {
                sb.append((character - key) >= 'A' ?
                        (char) (character - key) : (char) (character - key + 26));
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    public String unicode(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append((char) (message.charAt(i) - key));
        }
        return sb.toString();
    }
}