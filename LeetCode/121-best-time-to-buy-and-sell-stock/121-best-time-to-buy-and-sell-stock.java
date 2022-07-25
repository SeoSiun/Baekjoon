class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int result = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                if (max - min > result)
                    result = max - min;
                min = prices[i];
                max = min;
            }
            else if (prices[i] > max) {
                max = prices[i];
            }
        }
        if (max - min <= result) return result;
        if (max > min) return (max - min);
        else return (0);
    }
}