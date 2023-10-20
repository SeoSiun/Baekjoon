class Solution {
    private static int[][] answer;
    private static int idx;
    
    public int[][] solution(int n) {
        idx = 0;
        answer = new int[(int)Math.pow(2, n) - 1][2];
        move(n, 1, 3, 2);
        return answer;
    }
    
    private void move(int n, int src, int dest, int support) {
        // 원판이 1개라면 그냥 옮김
        if (n == 1) {
            answer[idx][0] = src;
            answer[idx++][1] = dest;
            return;
        }
        
        // 맨 아래 원판을 제외한 나머지를 support로 이동
        move(n - 1, src, support, dest);
        // 맨 아래 원판을 dest로 이동
        answer[idx][0] = src;
        answer[idx++][1] = dest;
        // 맨 아래 원판을 제외한 나머지를 dest로 이동
        move(n - 1, support, dest, src);
    }
}