class Solution {
    private int[] cnt;
    
    public int[] solution(int[][] arr) {
        this.cnt = new int[2];
        compress(arr, 0, 0, arr.length);
        return this.cnt;
    }
    
    private void compress(int[][] arr, int x, int y, int len) {        
        if (isAllElementEqual(arr, x, y, len)) {
            cnt[arr[y][x]]++;
            return;
        }
        int nextLen = len / 2;
        compress(arr, x, y, nextLen);
        compress(arr, x + nextLen, y, nextLen);
        compress(arr, x , y + nextLen, nextLen);
        compress(arr, x + nextLen, y + nextLen, nextLen);
    }
    
    private boolean isAllElementEqual(int[][] arr, int x, int y, int len) {
        int value = arr[y][x];
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}