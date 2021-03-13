import java.nio.charset.StandardCharsets;

public class palindromic_substrings {
    public static void main(String[] args) {
        System.out.println(countSubStrings("fdsklf"));
    }

    /**
     * 思路同下，
     * 时间复杂度O(n^2)
     *
     * @param s
     * @return
     */
    public static int countSubStrings(String s) {
        if (s.isEmpty()) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {//i为右区间，j为左区间
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 觮法二
     * 解题思路：
     * dp[i][j]在i,j区间的字符是否是回文字符串
     * 从中间往两边扩散，扩散之前i=j;
     * dp[i][j]为true的情况，s[i]==s[j]&&(j-1<2||dp[i+1][j-1])
     *
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        if (s.isEmpty()) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        int result = 1;
        for (int i = 1; i < s.length(); i++) {
            int n = i;
            int m = i;
            while (n >= 0 && m <= s.length() - 1) {
                if (s.charAt(n) == s.charAt(m) && (m - n < 2 || dp[n + 1][m - 1])) {
                    dp[n][m] = true;
                    result++;
                }
                if (i - n <= m - i) {
                    n--;
                } else {
                    m++;
                }
            }
        }
        return result;

    }
}
