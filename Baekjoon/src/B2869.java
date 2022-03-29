import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2869 {
    public static void main(String args[]) throws IOException {
        int A, B, V, dayCnt;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        A = Integer.parseInt(inputs[0]);
        B = Integer.parseInt(inputs[1]);
        V = Integer.parseInt(inputs[2]);

      //***** 시간 초과 *****//
//        curH = 0;
//        dayCnt = 0;
//
//        while(true){
//            dayCnt++;
//            curH += A;
//            if(curH >= V) break;
//            curH -= B;
//        }

        // 그냥 수식으로 하자!
        if((V-A) % (A-B)==0) dayCnt = (V-A)/(A-B) + 1;
        else dayCnt = (V-A)/(A-B) + 2;

        System.out.println(dayCnt);
    }
}
