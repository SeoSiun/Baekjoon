import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1712 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        if(C <= B){
            System.out.println("-1");
            return;
        }

        System.out.println(A/(C-B) + 1);
    }
}
