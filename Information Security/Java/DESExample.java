import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class DESExample {

    // Prepares the DES key (must be exactly 8 bytes)
    public static SecretKey getDESKey(String keyStr) {
        byte[] keyBytes = keyStr.substring(0, Math.min(keyStr.length(), 8)).getBytes();
        byte[] fullKey = new byte[8];
        for (int i = 0; i < 8; i++) {
            fullKey[i] = (byte) ((i < keyBytes.length) ? keyBytes[i] : '0');
        }
        return new SecretKeySpec(fullKey, "DES");
    }

    // Encrypt method
    public static String desEncrypt(String plaintext, String key) throws Exception {
        SecretKey desKey = getDESKey(key);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt method
    public static String desDecrypt(String ciphertext, String key) throws Exception {
        SecretKey desKey = getDESKey(key);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        System.out.print("Enter 8-character key: ");
        String key = scanner.nextLine();

        try {
            String encrypted = desEncrypt(message, key);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = desDecrypt(encrypted, key);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
