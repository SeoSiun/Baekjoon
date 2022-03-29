import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10809 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] tmp = br.readLine().toCharArray();
        int[] alpha = new int[26];
        Arrays.fill(alpha,-1);

        for(int i =0; i< tmp.length; i++){
            int index = (int)tmp[i] - 97;
            if(alpha[index] == -1) alpha[index] = i;
        }
        for(int i = 0; i < alpha.length; i++){
            System.out.print(alpha[i]+" ");
        }
    }
}
