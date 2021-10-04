import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5622 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int minTime = 0;

        for(int i=0; i<input.length(); i++){
            int diff = (int)input.charAt(i) - 65;

            if(diff < 3) minTime +=3;
            else if(diff < 6) minTime += 4;
            else if(diff < 9) minTime += 5;
            else if(diff < 12) minTime += 6;
            else if(diff < 15) minTime += 7;
            else if(diff < 19) minTime += 8;
            else if(diff < 22) minTime += 9;
            else minTime+= 10;
        }
        System.out.println(minTime);
    }
}
