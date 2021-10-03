import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2908 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNums = br.readLine().split(" ");

        int a = Integer.parseInt((new StringBuffer(inputNums[0])).reverse().toString());
        int b = Integer.parseInt((new StringBuffer(inputNums[1])).reverse().toString());

        if(a>b) System.out.println(a);
        else System.out.println(b);
    }
}
