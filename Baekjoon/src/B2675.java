import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2675 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        char[][] s = new char[t][];

        for(int i=0; i<t; i++){
            s[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<t; i++){
            int r = Character.getNumericValue(s[i][0]);

            for(int j=2; j<s[i].length; j++){
                for(int k=0; k<r; k++){
                    System.out.print(s[i][j]);
                }
            }
            System.out.println();
        }

    }
}
