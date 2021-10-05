import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2292 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dest = Integer.parseInt(br.readLine());
        int cnt=1, block=1;

        while(block < dest){
            block = block + 6 * cnt;
            cnt++;
        }
        System.out.println(cnt);
    }
}
