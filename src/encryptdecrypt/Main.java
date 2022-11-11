package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput(args);
        inputHandler.encryptDecrypt();
    }
}