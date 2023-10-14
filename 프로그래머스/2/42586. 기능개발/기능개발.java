import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int totalCnt = 0;
        while (totalCnt < progresses.length) {
            for (int i = totalCnt; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            int tmp = check(progresses, totalCnt);
            if (tmp > 0) {
                totalCnt += tmp;
                list.add(tmp);
            }
        }
        int[] answer = new int[list.size()];
        int idx = 0;
        for (Integer i : list) answer[idx++] = i;
        return answer;
    }
    
    private int check(int[] progresses, int totalCnt) {
        int cnt = 0;
        for (int i = totalCnt; i < progresses.length; i++) {
            if (progresses[i] >= 100) {
                cnt++;
            }
            else break;
        }
        return cnt;
    }
}