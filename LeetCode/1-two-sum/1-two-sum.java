class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        int diff;
        
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (diff == nums[j]) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }
}