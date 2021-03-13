/**
 * 解题思路：
 * dp[i][j]为以i,j为正方形右下角时的最大连长
 * 子问题：
 * 1.m[i][j]=='0',dp[i][j]=0;
 * 2.m[i][j]=='1', dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
 * 需要一个变量max记录最大边长
 * result = max*max
 */
public class maximal_square {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
