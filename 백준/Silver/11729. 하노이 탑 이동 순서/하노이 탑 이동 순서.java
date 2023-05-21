import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println((1<<n)-1);
        move(n,1,3);
        System.out.println(result);
    }

    private static void move(int n, int s, int e){
        if(n==1){
            result.append(s+" "+e + "\n");
            return;
        }
        // n-1개를 2번으로 옮김
        move(n-1, s, 6-s-e);
        // 가장 아래에 있는 애를 3번으로 옮김
        result.append(s+" "+e + "\n");
        // n-1개를 2에서 3으로 옮김
        move(n-1, 6-s-e, e);
    }
}