import java.util.Arrays;

public class minimum_path_sum {
    /**
     * 解题思路：
     * 1.子问题:向右或者向下
     * 2.dp方程：dp[i][j] = min(dp[i-1][j],dp[i][j-1])+ grid[i][j]
     * 3.保存：可以复用上一行的记录，用一维dp即可。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i - 1][j - 1];

            }
            dp[0] = Integer.MAX_VALUE;
        }
        return dp[n];
    }
}
