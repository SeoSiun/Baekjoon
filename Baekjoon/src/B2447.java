import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2447 {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        int n;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(board[i], ' ');
        draw(0,0,n);

        for(int i=0; i<n; i++){
            System.out.println(new String(board[i]));
        }
    }

    public static void draw(int x, int y, int n){
        if(n==1){
            board[x][y]='*';
            return;
        }

        int div_n = n/3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i!=1|| j!=1) draw(x + i * div_n, y + j * div_n, div_n);
            }
        }

    }
}
