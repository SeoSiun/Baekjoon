class Solution {
    public int maxProfit(int[] prices) {
        int min_price = prices[0];
        int max_profit = 0;
        int cur_profit;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            }
            else {
                cur_profit = prices[i] - min_price;
                if (cur_profit > max_profit)
                    max_profit = cur_profit;
            }
        }
        return max_profit;
    }
}