class Solution {
    private static int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        makeTarget(numbers, target, 0, 0);
        return cnt;
    }
    
    private void makeTarget(int[] numbers, int target, int idx, int cur) {
        if (idx == numbers.length) {
            if (target == cur) cnt++;
            return;
        }
        
        makeTarget(numbers, target, idx + 1, cur + numbers[idx]);
        makeTarget(numbers, target, idx + 1, cur - numbers[idx]);
    }
}