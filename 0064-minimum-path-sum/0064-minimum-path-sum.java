class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, grid);
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = dfs(i, j + 1, grid);
        int down = dfs(i + 1, j, grid);

        dp[i][j] = grid[i][j] + Math.min(right, down);

        return dp[i][j];
    }
}




