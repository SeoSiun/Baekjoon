import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775 {
    public static void main(String args[]) throws IOException {
        int t, k, n;
        int[] underFloor;
        int[] curFloor = new int[14];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // num of testcase
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            // K층
            k = Integer.parseInt(br.readLine());
            // n호
            n = Integer.parseInt(br.readLine());
            underFloor = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

            for(int j=0; j<k; j++){
                for(int l=0; l<n; l++){
                    if(l==0) curFloor[l] = underFloor[0];
                    else curFloor[l] = curFloor[l-1] + underFloor[l];
                }
                underFloor = curFloor;
            }
            System.out.println(curFloor[n-1]);
        }
    }
}