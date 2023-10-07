import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int weight = 1;
        List<Integer> n3 = new ArrayList<>();
        
        while(n > 0) {
            n3.add(n % 3);
            n /= 3;
        }
        
        for (int i = n3.size() - 1; i >= 0; i--) {
            answer += n3.get(i) * weight;
            weight *= 3;
        }
        
        return answer;
    }
}