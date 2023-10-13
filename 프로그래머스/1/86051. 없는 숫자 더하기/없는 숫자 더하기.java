import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] allNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        for (int n: numbers) list.add(n);
        
        for (int n : allNumbers) {
            if (!list.contains(n)) answer += n;
        }
        return answer;
    }
}