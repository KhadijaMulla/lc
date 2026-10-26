class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    long sum = dfs(i, j, grid, visited);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public long dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length ||
            j >= grid[0].length || grid[i][j] == 0 ||
            visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        long sum = grid[i][j];

        sum += dfs(i + 1, j, grid, visited);
        sum += dfs(i - 1, j, grid, visited);
        sum += dfs(i, j + 1, grid, visited);
        sum += dfs(i, j - 1, grid, visited);

        return sum;
    }
}