import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870 {
    public static void main(String[] args) throws IOException {
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(f(n));
    }

    private static int f(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return f(n-1) + f(n-2);
    }
}
