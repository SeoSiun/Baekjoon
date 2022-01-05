import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1193 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int level = 1;
        int p, c;

        while(X > level){
            X = X - level;
            level++;
        }

        if(level % 2 == 0){
            p = level - X + 1;
            c = X;
        }
        else{
            p = X;
            c = level - X + 1;
        }

        System.out.println(c+"/"+p);
    }
}
