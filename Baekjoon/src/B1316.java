import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1316 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        String tmp;

        for(int i=0; i<N; i++) {
            tmp = "";
            String input = br.readLine();

            for(int j=0; j<input.length(); j++){
                if(tmp.indexOf(input.charAt(j))!=-1 && tmp.charAt(tmp.length()-1) != input.charAt(j)) break;
                else tmp += input.charAt(j);

                if(j == input.length()-1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
