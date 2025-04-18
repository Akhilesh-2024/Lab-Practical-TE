import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class AESAlgorithm {

    public static SecretKeySpec getAESKey(String keyStr) {
        byte[] keyBytes = keyStr.getBytes();
        byte[] key = new byte[16];
        for (int i = 0; i < 16; i++) {
            key[i] = (byte) ((i < keyBytes.length) ? keyBytes[i] : '0');
        }
        return new SecretKeySpec(key, "AES");
    }

    public static String aesEncrypt(String plaintext, String key) throws Exception {
        SecretKeySpec aesKey = getAESKey(key);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());

        // Combine IV and encrypted data
        byte[] combined = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, combined, 0, iv.length);
        System.arraycopy(encrypted, 0, combined, iv.length, encrypted.length);

        return Base64.getEncoder().encodeToString(combined);
    }

    public static String aesDecrypt(String ciphertext, String key) throws Exception {
        SecretKeySpec aesKey = getAESKey(key);
        byte[] combined = Base64.getDecoder().decode(ciphertext);

        byte[] iv = new byte[16];
        byte[] encryptedData = new byte[combined.length - 16];
        System.arraycopy(combined, 0, iv, 0, 16);
        System.arraycopy(combined, 16, encryptedData, 0, encryptedData.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, aesKey, ivSpec);

        byte[] decrypted = cipher.doFinal(encryptedData);
        return new String(decrypted);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        System.out.print("Enter 16-character key: ");
        String key = scanner.nextLine();

        try {
            String encrypted = aesEncrypt(message, key);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = aesDecrypt(encrypted, key);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
