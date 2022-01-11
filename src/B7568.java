import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B7568 {
    public static void main(String[] args) throws IOException {
        int n;
        String[] inputs;
        int[][] info;
        int[] rank;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n][2];
        rank = new int[n];
        Arrays.fill(rank,0);

        for(int i=0; i<n; i++){
            inputs = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(inputs[0]);
            info[i][1] = Integer.parseInt(inputs[1]);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(info[i][0] < info[j][0] && info[i][1] < info[j][1]) rank[i]++;
            }
        }
        for(int i=0; i<n; i++){
            System.out.print((rank[i]+1)+" ");
        }
    }
}
