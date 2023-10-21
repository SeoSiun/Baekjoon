class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            win[result[0]][result[1]] = true;
        }
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (countWin(win, i, new boolean[n + 1]) + countLose(win, i, new boolean[n  + 1]) - 1 == n) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private int countWin(boolean[][] win, int i, boolean[] isVisited) {
        int cnt = 1;
        for (int j = 1; j < win[i].length; j++) {
            if (!win[i][j] || isVisited[j]) {
                continue;
            }
            isVisited[j] = true;
            cnt += countWin(win, j, isVisited);
        }
        return cnt;
    }
    
    private int countLose(boolean[][] win, int i, boolean[] isVisited) {
        int cnt = 1;
        for (int j = 1; j < win[i].length; j++) {
            if (!win[j][i] || isVisited[j]) {
                continue;
            }
            isVisited[j] = true;
            cnt += countLose(win, j, isVisited);
        }
        return cnt;
    }
}