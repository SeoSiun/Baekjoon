class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // 같은 숫자가 3번 연속 나올 때 마지막(3으로 나눴을 때 나머지가 2)이 아닌데 다음거랑 다른 경우
            if (nums[i] != nums[i + 1] && i % 3 != 2)     
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}