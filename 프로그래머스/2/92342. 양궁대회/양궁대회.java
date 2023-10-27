import java.util.*;

class Solution {
    int[] answer = {-1};
    int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        findLionInfo(n, info, info.length - 1, new int[info.length]);
        return answer;
    }
    
    private void findLionInfo(int n, int[] info, int idx, int[] lionInfo) {
        if (n == 0) {
            int diff = getScoreDiff(info, lionInfo);
            if (diff >  maxDiff) {
                answer = lionInfo;
                maxDiff = diff;
            }
            return;
        }
        if (idx < 0) return;
        
        for (int i = n; i >= 0; i--) {
            int[] clone = lionInfo.clone();
            clone[idx] = i;
            findLionInfo(n - i, info, idx - 1, clone);
        }
    }
    
    // 라이언 - 어피치
    private int getScoreDiff(int[] apeach, int[] lion) {
        int diff = 0;
        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] == 0 && lion[i] == 0) continue;
            else if (apeach[i] >= lion[i]) diff -= 10 - i;
            else diff += 10 - i;
        }
        return diff;
    }
}