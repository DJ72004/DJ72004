import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RSA{
    private BigInteger p, q, N, phi, e, d;
    private int bitLength = 1024;
    private Random r;

    public RSA() {
        r = new Random();
        p = BigInteger.probablePrime(bitLength, r);
        q = BigInteger.probablePrime(bitLength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitLength / 2, r);
        d = e.modInverse(phi);
    }

    public static void main(String[] args) throws IOException {
        RSA rsa = new RSA();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the plain text: ");
        String testString = br.readLine();
        byte[] encrypted = rsa.encrypt(testString.getBytes());
        System.out.println("Encryted" + new String(encrypted, StandardCharsets.UTF_8));
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted string: " + new String(decrypted, StandardCharsets.UTF_8));
    }

    
    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}
