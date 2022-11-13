import cryptors.Encryptor;
import inputHandle.InputHandler;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Encryptor encryptor = new Encryptor();
        System.out.println(encryptor.unicode("abcde", 5));
        System.out.println(encryptor.unicode("vwXyZ!", 5));
        inputHandler.handleInput(args);
        inputHandler.crypt();
    }
}