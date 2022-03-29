import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1152 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] split = input.split(" ");

        int cnt=0;

        for(int i=0; i<split.length; i++){
            if(split[i].length() > 0 ) cnt++;
        }

        System.out.println(cnt);

    }
}
