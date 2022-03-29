import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10989 {
    public static void main(String[] args) throws IOException {
        int n, idx;
        int[] nums = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++)
        {
            idx = Integer.parseInt(br.readLine());
            nums[idx]++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < 10001; i++)
        {
            while (nums[i] > 0) {
                result.append(i).append("\n");
                nums[i]--;
            }
        }
        System.out.println(result);
    }
}
