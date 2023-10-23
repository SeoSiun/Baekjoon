import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {        
        Set<Integer> lostSet = new HashSet<>();
        for (int l: lost) lostSet.add(l);
        Set<Integer> tmp = new HashSet<>(lostSet);
        Set<Integer> reserveSet = new HashSet<>();
        for (int r: reserve) reserveSet.add(r);
        
        lostSet.removeAll(reserveSet);
        reserveSet.removeAll(tmp);

        int answer = n - lostSet.size();
        
        return answer + Math.max(count1(lostSet, new HashSet<>(reserveSet)), count2(lostSet, new HashSet<>(reserveSet)));
    }
    
    private int count1(Set<Integer> lostSet, Set<Integer> reserveSet) {
        int cnt = 0;
        for (Integer l: lostSet) {
            if (reserveSet.remove(l + 1) || reserveSet.remove(l - 1)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private int count2(Set<Integer> lostSet, Set<Integer> reserveSet) {
        int cnt = 0;
        for (Integer l: lostSet) {
            if (reserveSet.remove(l - 1) || reserveSet.remove(l + 1)) {
                cnt++;
            }
        }
        return cnt;
    }
}