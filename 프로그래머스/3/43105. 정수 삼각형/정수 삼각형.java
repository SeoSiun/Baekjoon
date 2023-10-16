class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = triangle.clone();
        
        dp[0][0] = triangle[0][0];
        for (int row = 1; row < triangle.length; row++) {
            dp[row][0] = dp[row - 1][0] + triangle[row][0];
            for (int col = 1; col < triangle[row].length - 1; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row - 1][col - 1]) + triangle[row][col];
            }
            dp[row][triangle[row].length - 1] = dp[row - 1][triangle[row].length - 2] + dp[row][triangle[row].length - 1];
        }
        for (int col = 0; col < triangle[triangle.length - 1].length; col++) {
            answer = Math.max(answer, triangle[triangle.length - 1][col]);
        }
        return answer;
    }
}