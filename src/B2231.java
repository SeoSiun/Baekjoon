import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231 {
    public static void main(String[] args) throws IOException {
        int n, l, sol, isSol, tmp;
        String input;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        n = Integer.parseInt(input);
        l = input.length();
        sol = n - l * 9;

        for(int i=0; i<l*9; i++){
            isSol = sol;
            tmp = sol;
            while(tmp!=0){
                isSol += tmp%10;
                tmp = tmp/10;
            }
            if(isSol == n){
                System.out.println(sol);
                return;
            }
            sol++;
        }
        System.out.println(0);

    }
}
