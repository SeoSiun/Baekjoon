import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2941 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        input = input.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "*");

        System.out.println(input.length());
    }
}
