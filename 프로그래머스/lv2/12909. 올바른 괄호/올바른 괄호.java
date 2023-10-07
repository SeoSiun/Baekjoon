import java.util.*;

class Solution {
    boolean solution(String s) {
        int leftCnt = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '(') leftCnt++;
            if (c == ')') {
                if (leftCnt <= 0) return false;
                leftCnt--;
            }
        }
        
        return leftCnt == 0;
    }
}