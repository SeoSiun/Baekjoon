import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839 {
    public static void main(String args[]) throws IOException {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        switch (N%5){
            case 0:
                // 5kg: N/5개, 3kg: 0개
                System.out.println(N/5);
                break;
            case 1:
                // 5kg: (N/5-1)개, 3kg: 2개
                if(N/5 < 1) System.out.println(-1);
                else System.out.println(N/5+1);
                break;
            case 2:
                // 5kg: (N/5-2)개, 3kg: 4개
                if(N/5 < 2) System.out.println(-1);
                else System.out.println(N/5+2);
                break;
            case 3:
                // 5kg: N/5개, 3kg: 1개
                System.out.println(N/5+1);
                break;
            case 4:
                // 5kg: (N/5-1)개, 3kg: 3개
                if(N/5 < 1) System.out.println(-1);
                else System.out.println(N/5+2);
                break;
        }

    }
}
