package Level2;

import java.util.ArrayList;

public class 기능개발 {
    public static void main(String[] argv) {
        int[] p1 = {93, 30, 55};
        int[] p2 = {95, 90, 99, 99, 80, 99};
        int[] s1 = {1, 30, 5};
        int[] s2 = {1, 1, 1, 1, 1, 1};

        System.out.println("ex1");
        int[] r1 = solution(p1, s1);
        for (int i: r1) System.out.println(i);

        System.out.println("ex2");
        int[] r2 = solution(p2, s2);
        for (int i: r2) System.out.println(i);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> res = new ArrayList<>();
        int first = 0;
        int release = 0;
        int i;

        while (first < progresses.length) {
            for (i = first; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if (i == first && progresses[i] >= 100) {
                    release++;
                    first++;
                }
            }
            if (release > 0) {
                res.add(release);
                release = 0;
            }
        }
        answer = new int[res.size()];
        for (i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}
