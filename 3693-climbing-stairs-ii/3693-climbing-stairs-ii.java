class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            int min = Integer.MAX_VALUE;

            if (i >= 1) {
                min = Math.min(min, dp[i - 1] + 1);
            }

            if (i >= 2) {
                min = Math.min(min, dp[i - 2] + 4);
            }

            if (i >= 3) {
                min = Math.min(min, dp[i - 3] + 9);
            }

            dp[i] = costs[i - 1] + min;
        }

        return dp[n];
    }
}



