import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10250 {
    public static void main(String args[]) throws IOException {
        int T, H, W, N, Y, X;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T: 테스트 데이터의 수
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String[] inputs = br.readLine().split(" ");
            // H: 호텔 층 수
            H = Integer.parseInt(inputs[0]);
            // W: 각 층의 방 수
            W = Integer.parseInt(inputs[1]);
            // N: 몇 번째 손님인지
            N = Integer.parseInt(inputs[2]);

            // N번째 손님의 층
            Y = (N-1) % H + 1;
            // N번째 손님의 호수
            X = (N-1) / H + 1;

            if(X < 10) System.out.println(Y+"0"+X);
            else System.out.println(Y+""+X);
        }
    }
}
