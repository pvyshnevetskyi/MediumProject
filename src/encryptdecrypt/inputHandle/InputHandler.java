package encryptdecrypt.inputHandle;

import encryptdecrypt.cryptors.Decryptor;
import encryptdecrypt.cryptors.Encryptor;

import java.io.*;
import java.util.Scanner;

public class InputHandler {
    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String fileReadFrom;
    private String fileWriteTo;

    public void handleInput(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                data = args[i + 1];
            }
            if (args[i].equals("-in")) {
                fileReadFrom = args[i + 1];
            }
            if (args[i].equals("-out")) {
                fileWriteTo = args[i + 1];
            }
        }
    }

    public void encryptDecrypt() {
        if (mode.equals("enc")) {
            encrypt();
        }
        if (mode.equals("dec")) {
            decrypt();
        }
    }

    public void encrypt() {
        Encryptor encryptor = new Encryptor();
        if (data.equals("")) {
            readFromFile();
        }
        if (fileWriteTo == null) {
            System.out.println(encryptor.encrypt(data, key));
        } else {
            writeIntoFile(encryptor.encrypt(data, key));
        }
    }

    public void decrypt() {
        Decryptor decryptor = new Decryptor();
        if (data.equals("")) {
            readFromFile();
        }
        if (fileWriteTo == null) {
            System.out.println(decryptor.decrypt(data, key));
        } else {
            writeIntoFile(decryptor.decrypt(data, key));
        }
    }

    private void writeIntoFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWriteTo))) {
            writer.write(data);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    private void readFromFile() {
        File file = new File(fileReadFrom);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            data = sb.toString();
        } catch (FileNotFoundException exc) {
            System.out.println("Error " + exc.getMessage());
        }
    }

}