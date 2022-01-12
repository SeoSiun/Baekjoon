import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1018 {
    public static void main(String[] args) throws IOException {
        int n, m, cur, min;
        String[] inputs;
        char[][] board, tmpBoard;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        board = new char[n][m];
        tmpBoard = new char[n][];

        for(int i=0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        min = Integer.MAX_VALUE;

        for(int i=0; i< n-7; i++){
            for(int j=0; j<m-7; j++){
                // (i,j)를 start point로 자름
                for(int p=0; p<2; p++) {
                    cur=0;
                    // deep copy
                    for (int k = 0; k < n; k++) {
                        tmpBoard[k] = board[k].clone();
                    }
                    if(p==1){
                        // start point의 색을 바꾸는 경우
                        if(tmpBoard[i][j]=='W') tmpBoard[i][j] = 'B';
                        else tmpBoard[i][j] = 'W';
                        cur++;
                    }
                    // start point부터 시작해서 현재 point의 오른쪽, 아래쪽과 색이 같으면 오른쪽, 아래쪽의 색을 바꿈
                    for (int k = i; k < i + 8; k++) {
                        for (int l = j; l < j + 7; l++) {
                            if (tmpBoard[k][l] == tmpBoard[k][l + 1]) {
                                if (tmpBoard[k][l + 1] == 'W') tmpBoard[k][l + 1] = 'B';
                                else tmpBoard[k][l + 1] = 'W';
                                cur++;
                            }
                            if (k != i + 7 && tmpBoard[k][l] == tmpBoard[k + 1][l]) {
                                if (tmpBoard[k + 1][l] == 'W') tmpBoard[k + 1][l] = 'B';
                                else tmpBoard[k + 1][l] = 'W';
                                cur++;
                            }
                        }
                    }
                    if (cur < min) min = cur;
                }
            }
        }
        System.out.println(min);
    }
}
