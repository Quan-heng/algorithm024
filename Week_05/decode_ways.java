/**
 * 解题思路：
 * dp[i]为 s.subString(0,i)的解码数
 * 子问题
 * 1. s[i] = ‘0’时，如果 s[i-1]=='1' 或 s[i-1] == '2', dp[i] = dp[i-2]
 * 2. s[i] != '0'时, 如果 s[i-1] =='1'，dp[i] = dp[i-1]+dp[i-2] //s[i-1],s[i],拆分或者合并
 * 如果 s[i-1] == '2'同量s[i]在'0'到‘6’之间，同上。
 */
public class decode_ways {
    /**
     * 一维数组版
     *
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if (s.startsWith("0")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6')) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 变量版
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        //int[] dp = new int[s.length() + 1];
        int cur = 1;//dp[0]
        int prev = 1;//dp[-1]

        for (int i = 1; i < s.length(); i++) {
            int temp = cur;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    cur = prev;//dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
                    cur = cur + prev; //dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            prev = temp;
        }
        return cur;//dp[s.length() - 1];
    }
}
