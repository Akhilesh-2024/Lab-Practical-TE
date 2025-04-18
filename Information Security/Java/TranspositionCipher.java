import java.util.Scanner;

public class TranspositionCipher {

    public static String encryptMessage(String plaintext, int key) {
        StringBuilder[] ciphertext = new StringBuilder[key];

        for (int i = 0; i < key; i++) {
            ciphertext[i] = new StringBuilder();
        }

        for (int column = 0; column < key; column++) {
            int pointer = column;
            while (pointer < plaintext.length()) {
                ciphertext[column].append(plaintext.charAt(pointer));
                pointer += key;
            }
        }

        StringBuilder finalCipher = new StringBuilder();
        for (StringBuilder col : ciphertext) {
            finalCipher.append(col);
        }

        return finalCipher.toString();
    }

    public static String decryptMessage(String ciphertext, int key) {
        int numOfColumns = (int) Math.ceil((double) ciphertext.length() / key);
        int numOfRows = key;
        int numOfShadedBoxes = (numOfColumns * numOfRows) - ciphertext.length();

        StringBuilder[] plainTextCols = new StringBuilder[numOfColumns];
        for (int i = 0; i < numOfColumns; i++) {
            plainTextCols[i] = new StringBuilder();
        }

        int column = 0;
        int row = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            plainTextCols[column].append(ciphertext.charAt(i));
            column++;

            if (column == numOfColumns || (column == numOfColumns - 1 && row >= numOfRows - numOfShadedBoxes)) {
                column = 0;
                row++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (i < plainTextCols[j].length()) {
                    result.append(plainTextCols[j].charAt(i));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your plain text: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter key: ");
        int key = scanner.nextInt();
        scanner.nextLine(); 

        String encrypted = encryptMessage(plaintext, key);
        System.out.println("Encrypted text: " + encrypted);

        // Decryption
        System.out.print("\nEnter cipher text: ");
        String cipherInput = scanner.nextLine();
        System.out.print("Enter key: ");
        int decryptKey = scanner.nextInt();

        String decrypted = decryptMessage(cipherInput, decryptKey);
        System.out.println("Decrypted text: " + decrypted);

        scanner.close();
    }
}
