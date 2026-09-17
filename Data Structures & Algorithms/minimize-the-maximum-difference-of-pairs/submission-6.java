class Solution {
    public int minimizeMax(int[] nums, int p) {
        int[][] dp = new int[nums.length+1][p+1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        
        for (int pairs = 1; pairs <= p; pairs++) {
            for (int i = nums.length - 2; i >= 0; i--) {
                int skip = dp[i+1][pairs];
                int take = Integer.MAX_VALUE;
                if (i + 1 < nums.length) {
                    take = Math.max(nums[i+1] - nums[i], dp[i+2][pairs-1]);
                }
                dp[i][pairs] = Math.min(skip, take);
            }
        }
        return dp[0][p];
    }
}