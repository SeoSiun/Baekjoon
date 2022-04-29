package Level2;

import java.util.Arrays;

public class 프린터 {
    public static void main(String[] argv) {
        int[] p1 = {2, 1, 3, 2};
        int[] p2 = {1, 1, 9, 1, 1, 1};
        int l1 = 2;
        int l2 = 0;

        System.out.println("ex1");
        System.out.println(solution(p1, l1));

        System.out.println("ex2");
        System.out.println(solution(p2, l2));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        boolean is_end = false;
        int[] sorted = priorities.clone();
        Arrays.sort(sorted);

        while (!is_end) {
            is_end = true;
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] != -1 && priorities[i] >= sorted[priorities.length - answer]) {
                    if (i == location) return answer;
                    priorities[i] = -1;
                    answer++;
                }
                if (priorities[i] != -1) is_end = false;
            }
        }
        return answer;
    }
}
