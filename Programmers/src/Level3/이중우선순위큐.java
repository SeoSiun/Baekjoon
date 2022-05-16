package Level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] argv) {
        String[] o1 = {"I 16", "D 1"};
        String[] o2 = {"I 7", "I 5", "I -5", "D -1"};
        int[] r1 = solution(o1);
        int[] r2 = solution(o2);

        System.out.println("ex1");
        System.out.println(r1[0] + ", " + r1[1]);

        System.out.println("ex2");
        System.out.println(r2[0] + ", " + r2[1]);
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Integer tmp;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (String o : operations) {
            if (o.charAt(0) == 'I') {
                tmp = Integer.parseInt(o.substring(2));
                min.add(tmp);
                max.add(tmp);
            }
            else if (o.equals("D 1") && !min.isEmpty())
                min.remove(max.remove());
            else if (o.equals("D -1") && !max.isEmpty())
                max.remove(min.remove());
        }
        if (!min.isEmpty() && !max.isEmpty()) {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
}
