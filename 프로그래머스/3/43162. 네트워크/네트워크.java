class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                answer++;
                checkNetwork(i, computers, checked);
            }
        }
        return answer;
    }
    
    private void checkNetwork(int cur, int[][] computers, boolean[] checked) {
        for (int i = 0; i < computers.length; i++) {
            if (!checked[i] && computers[cur][i] == 1) {
                checked[i] = true;
                checkNetwork(i, computers, checked);
            }
        }
    }
}