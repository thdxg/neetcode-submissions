class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        return profit(prices, 0, 0);
    }

    // every day choice: 
    // if bought: sell, skip
    // if not bought: buy, skip
    private int profit(int[] prices, int today, int bought) {
        if (today == prices.length) return 0;
        if (dp[today][bought] != 0) return dp[today][bought];
        int max = profit(prices, today + 1, bought);
        if (bought == 1) {
            max = Math.max(max, prices[today] + profit(prices, today + 1, 0));
        } else {
            max = Math.max(max, -prices[today] + profit(prices, today + 1, 1));
        }
        dp[today][bought] = max;
        return max;
    }
}