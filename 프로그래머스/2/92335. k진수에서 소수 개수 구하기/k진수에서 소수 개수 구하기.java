class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // k진수로 변환 후 0+를 기준으로 split
        String[] candidates = convertToK(n, k).split("0+");
        
        for (String c : candidates) {
            if (isPrime(Long.parseLong(c))) answer++;
        }
        return answer;
    }
    
    private String convertToK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}