package encryptdecrypt;

public class Encryptor {

    public String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'a' &&
                    message.charAt(i) <= 'z') {
                sb.append((char) ('a' + 'z' - message.charAt(i)));
            } else {
                sb.append(message.charAt(i));
            }
        }
        return sb.toString();
    }

    public String encrypt(String message, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append((char) (message.charAt(i) + key));
        }
        return sb.toString();
    }
}
