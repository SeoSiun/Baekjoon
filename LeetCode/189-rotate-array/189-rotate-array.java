class Solution {
    public void rotate(int[] nums, int k) {
        int[] tmpNums = nums.clone();
        int rotate = k % nums.length;

        
        for (int i = 0; i < rotate; i++) {
            nums[i] = tmpNums[tmpNums.length - rotate + i];
        }
        for (int j = 0; j < nums.length - rotate; j++) {
            nums[rotate + j] = tmpNums[j];
        }
    }
}