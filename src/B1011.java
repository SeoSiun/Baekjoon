import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1011 {
    public static void main(String[] args) throws IOException {
        int T, x, y, d, k;
        String[] inputs;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            inputs = br.readLine().split(" ");
            x = Integer.parseInt(inputs[0]);
            y = Integer.parseInt(inputs[1]);

            d = y-x;
            k = 1;

            while(d > k * 2){
                d -= k * 2;
                k++;
            }

            if(d >= k+1) System.out.println((k-1)*2 + 2);
            else System.out.println((k-1)*2 + 1);
        }
    }
}
