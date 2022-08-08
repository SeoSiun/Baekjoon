class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxAmount = 0;
        
        while (start < end) {
            int startH = height[start];
            int endH = height[end];
            maxAmount = Math.max(maxAmount, (end - start) * Math.min(startH, endH));
            if (startH < endH)
                start++;
            else
                end--;
        }
        return maxAmount;
    }
}
