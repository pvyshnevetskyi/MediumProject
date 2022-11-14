package cryptors;

public class Decryptor implements Cryptor {
    public String unicode(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append((char) (message.charAt(i) - key));
        }
        return sb.toString();
    }

    public String shift(String message, int key) {
        StringBuilder sb = new StringBuilder();
        char character;
        for (int i = 0; i < message.length(); i++) {
            character = message.charAt(i);
            if (character >= 'a' && character <= 'z') {
                sb.append(shiftLowerCaseCharacter(character, key));
            } else if (character >= 'A' && character <= 'Z') {
                sb.append(shiftUpperCaseCharacter(character, key));
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    private char shiftUpperCaseCharacter(char character, int key) {
        return (char) ((character - key) >= 'A' ? (character - key) : (character - key + 26));
    }

    private char shiftLowerCaseCharacter(char character, int key) {
        return (char) ((character - key) >= 'a' ? (character - key) : (character - key + 26));
    }
}