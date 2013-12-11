import java.math.BigInteger;
import java.util.Random;

public class RSAHelper {

    public BigInteger p;
    public BigInteger q;
    public BigInteger n;
    public BigInteger phin;
    public BigInteger e;
    private BigInteger d;

    public RSAHelper(int bitLength) {
        p = BigInteger.probablePrime(bitLength / 2, new Random()); //new BigInteger(bitLength, 15, new Random());
        q = BigInteger.probablePrime(bitLength / 2, new Random()); //new BigInteger(bitLength, 15, new Random());                  n = p.multiply(q);
        n = p.multiply(q);
        phin = p.subtract(BigInteger.ONE);
        phin = phin.multiply(q.subtract(BigInteger.ONE));

        while (true) {
            e = new BigInteger(phin.bitLength(), new Random());
            if (!e.equals(BigInteger.ONE) && e.gcd(phin).equals(BigInteger.ONE)) {
                break;
            }
        }
        d = e.modInverse(phin);
    }

    public BigInteger encrypt(BigInteger b) {
        return b.modPow(e, n);
    }

    public BigInteger encrypt(String message) {
        BigInteger messageBytes = new BigInteger(message.getBytes());
        return encrypt(messageBytes);
    }

    public BigInteger decrypt(BigInteger b){
        return b.modPow(d, n);
    }

}
