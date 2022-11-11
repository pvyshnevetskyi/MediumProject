package encryptdecrypt;

import encryptdecrypt.inputHandle.InputHandler;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput(args);
        inputHandler.encryptDecrypt();
    }
}