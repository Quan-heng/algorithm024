/**
 * 解题思路：
 * 1.推导
 * )()())
 * 002040
 * dp[i],为i位置以前最长子括号长度
 * 2.公式：
 * -如果i上元素为')',且s[i-dp[i-1]-1]='('
 * dp[i] = dp[i-1]+dp[i-2] +2; //dp[i-2]=0,说明之前的有效括号被中断，不为0刚加上前面的有效的括号数
 * -如果i上元素为'(',dp[i] = 0; //中断位置
 */
public class longest_valid_parenttheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()((())"));
    }
    public static int longestValidParentheses(String s) {
        int result = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
