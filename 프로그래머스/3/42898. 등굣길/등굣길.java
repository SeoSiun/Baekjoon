import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] memo = new int[m + 1][n + 1];
        
        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < m + 1; col++) {
                if (row == 1 && col == 1) {
                    memo[col][row] = 1;
                }
                else if (isPuddle(row, col, puddles)) {
                    memo[col][row] = 0;
                }
                else {
                    memo[col][row] += (memo[col - 1][row] + memo[col][row - 1]) % 1000000007;
                }
            }
        }
        return memo[m][n];
    }
    
    private boolean isPuddle(int row, int col, int[][] puddles) {
        for (int[] puddle: puddles) {
            if (puddle[0] == col && puddle[1] == row) return true;
        }
        return false;
    }
}