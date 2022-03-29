import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B10757 {
    public static void main(String[] args) throws IOException {
        BigInteger A, B;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        A = new BigInteger(inputs[0]);
        B = new BigInteger(inputs[1]);

        System.out.println(A.add(B));
    }
}
