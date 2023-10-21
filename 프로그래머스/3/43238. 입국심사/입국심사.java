class Solution {
    public long solution(int n, int[] times) {
        long s = 1;
        long e = 1000000000000000000L;
        
        while (e > s) {
            long m = (s + e) / 2;
            
            if (isValid(m, n, times)) {
                e = m;
            }
            else {
                s = m + 1;
            }
        }
        return s;
    }
    
    private boolean isValid(long t, int n, int[] times) {
        long cnt = 0;
        for (int time : times) {
            cnt += t / (long)time;
        }
        return cnt >= n;
    }
}