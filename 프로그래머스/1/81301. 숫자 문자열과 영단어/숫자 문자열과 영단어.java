class Solution {
    private String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        for (int i = 0; i < nums.length; i++) {
            s = s.replaceAll(nums[i], "" + i);
        }
        return Integer.parseInt(s);
    }
}