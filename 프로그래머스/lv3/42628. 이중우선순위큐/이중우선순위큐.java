import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
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