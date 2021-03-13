public class min_distance {
    /**
     * 解题思路
     * 可以定义dp[i][j],为word1.sub(0,i)到word2.sub(0,j)的最小变换数
     * 1.折分子问题:
     * 1）插入，word1第i+1个元素与word2第j个元素抵消，dp[i][j] = dp[i][j-1]+1
     * 2）删除,dp[i][j] = dp[i-1][j]+1
     * 3）替换,dp[i][j] = dp[i-1][j-1]+1;
     * 综上，dp就是以上三种情况的最小值dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
     * 时间、空间复杂度均为o(word1.length*word2.length)
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) {
            return Math.max(n, m);//一个为空，只进行插入操作
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
