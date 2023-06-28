import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caesar Cipher Program");
        System.out.println("---------------------");

        System.out.print("Enter the plaintext message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the encryption key (shift value): ");
        int key = scanner.nextInt();

        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    private static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                ch = (char) ((ch + key - 'a') % 26 + 'a');
            }

            encrypted.append(ch);
        }

        return encrypted.toString();
    }

    private static String decrypt(String message, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                ch = (char) ((ch - key - 'a' + 26) % 26 + 'a');
            }

            decrypted.append(ch);
        }

        return decrypted.toString();
    }
}
