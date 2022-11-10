package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfOperation = scanner.nextLine();
        String phrase = scanner.nextLine();
        int key = scanner.nextInt();

        if (typeOfOperation.equals("enc")) {
            Encryptor encryptor = new Encryptor();
            System.out.println(encryptor.encrypt(phrase, key));
        } else if (typeOfOperation.equals("dec")){
            Decryptor decryptor = new Decryptor();
            System.out.println(decryptor.decrypt(phrase, key));
        }
    }
}
