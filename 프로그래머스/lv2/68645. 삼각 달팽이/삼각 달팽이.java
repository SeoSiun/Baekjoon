class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int maxNum = n * (n + 1) / 2;
        int[] answer = new int[maxNum];

        int row = -1, col = 0, curNum = 1;
        while (curNum <= maxNum) {
            while (row + 1 < n && triangle[row + 1][col] == 0) {
                triangle[++row][col] = curNum++;
            }

            while (col + 1 < n && triangle[row][col + 1] == 0) {
                triangle[row][++col] = curNum++;
            }

            while (row - 1 > 0 && col - 1 > 0 && triangle[row - 1][col - 1] == 0) {
                triangle[--row][--col] = curNum++;
            }
        }

        int index = 0;
        for(row = 0; row < n; row++) {
            for(col = 0; col < row + 1; col++) {
                answer[index++] = triangle[row][col];
            }
        }
        return answer;
    }
}
