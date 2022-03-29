import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class B1157 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toUpperCase(Locale.ROOT).toCharArray();
        Arrays.sort(input);

        char maxChar = input[0], curChar = input[0];
        int curCnt=0, maxCnt=0;

        for(int i=0; i<input.length; i++){
            if(curChar != input[i]){
                curChar = input[i];
                curCnt = 0;
            }
            curCnt++;

            if(maxCnt < curCnt){
                maxCnt = curCnt;
                maxChar = input[i];
            }
            else if(maxCnt == curCnt) maxChar='?';
        }
        System.out.println(maxChar);
    }
}
