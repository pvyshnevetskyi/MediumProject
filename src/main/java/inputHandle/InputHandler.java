package inputHandle;


import cryptors.Cryptor;
import factory.CryptorFactory;

import java.io.*;
import java.util.Scanner;

public class InputHandler {
    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String fileReadFrom;
    private String fileWriteTo;
    private String algorithm = "shift";

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
            if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            }
        }
    }

    public void crypt() {
        Cryptor cryptor = CryptorFactory.getCryptor(mode);
        if (data.equals("") && fileReadFrom != null) {
            readFromFile();
        }
        if (fileWriteTo == null) {
            cryptInConsole(cryptor);
        } else {
            cryptInFile(cryptor);
        }
    }

    public void cryptInConsole(Cryptor cryptor) {
        if (algorithm.equals("unicode")) {
            System.out.println(cryptor.unicode(data, key));
        } else {
            System.out.println(cryptor.shift(data, key));
        }
    }

    public void cryptInFile(Cryptor cryptor) {
        if (algorithm.equals("unicode")) {
            writeIntoFile(cryptor.unicode(data, key));
        } else {
            writeIntoFile(cryptor.shift(data, key));
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
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            data = sb.toString();
        } catch (FileNotFoundException exc) {
            System.out.println("Error " + exc.getMessage());
        }
    }
}