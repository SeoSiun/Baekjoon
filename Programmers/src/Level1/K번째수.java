package Level1;

import java.util.ArrayList;
import java.util.Collections;

public class K번째수 {
    public static void main(String[] argv) {
        for (int i : solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))
            System.out.println(i);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) tmp.add(array[j]);
            Collections.sort(tmp);
            answer[i] = tmp.get(commands[i][2] - 1);
            tmp.clear();
        }
        return answer;
    }
}
