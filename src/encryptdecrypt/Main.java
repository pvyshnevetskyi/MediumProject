package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor();
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        int key = scanner.nextInt();
        System.out.println(encryptor.encrypt(code, key));
    }
}
