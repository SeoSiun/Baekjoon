package Level2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public static void main(String[] argv) {
        int[] s = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(s, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int min;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);

        while (!pq.isEmpty()) {
            min = pq.remove();
            if (min >= K) return answer;
            else if (pq.isEmpty()) break;
            pq.add(min + pq.remove() * 2);
            answer++;
        }
        return -1;
    }
}
