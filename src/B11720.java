import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11720 {
    public static void main(String args[]) throws IOException {
        int N, sum=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[] tmp = br.readLine().toCharArray();

        for(int i=0; i<N; i++){
            sum += Character.getNumericValue(tmp[i]);
        }

        System.out.println(sum);
        br.close();
    }
}