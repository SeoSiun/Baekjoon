import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436 {
    public static void main(String[] args) throws IOException {
        int n, result;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = 665;

        while(n>0){
            result++;
            if(Integer.toString(result).contains("666")) n--;
        }
        System.out.println(result);
    }
}
