import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int bitLength = 512;
        RSAHelper rsa = new RSAHelper(bitLength);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plainText = in.next();
        System.out.println("\nPlain Text: " + plainText);
        BigInteger cipherText = rsa.encrypt(plainText);
        System.out.println("Cipher Text: " + cipherText);
        BigInteger decrypted = rsa.decrypt(cipherText);
        System.out.println("Decrypted: " + decrypted);
    }
}
