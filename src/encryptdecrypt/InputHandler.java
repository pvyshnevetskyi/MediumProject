package encryptdecrypt;

public class InputHandler {
    private String mode = "enc";
    private int key = 0;
    private String data = "";

    public void handleInput(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode") && args[i + 1].indexOf('-') != 0) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key") && args[i + 1].indexOf('-') != 0) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data") && args[i + 1].indexOf('-') != 0) {
                data = args[i + 1];
            }
        }
    }
    public void code() {
        if (mode.equals("enc")) {
            encrypt();
        }
        if (mode.equals("dec")) {
            decrypt();
        }
    }
    public void encrypt() {
        Encryptor encryptor = new Encryptor();
        System.out.println(encryptor.encrypt(data, key));
    }
    public void decrypt() {
        Decryptor decryptor = new Decryptor();
        System.out.println(decryptor.decrypt(data, key));
    }

}
