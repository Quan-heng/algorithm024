import java.util.Stack;

public class string_to_integer_atoi {
    public static int myAtoi(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int start = 0;
        while (start < s.length() && chars[start] == ' ') {
            start++;
        }
        if (start == s.length()) {
            return 0;
        }
        if (!isNumber(chars[start]) && chars[start] != '-' && chars[start] != '+') return 0;
        int prefix = chars[start] == '-' ? -1 : 1;
        int i;
        if (isNumber(chars[start])) {
            i = start;
        } else {
            i = start + 1;
        }
        int result = 0;
        while (i < s.length() && isNumber(chars[i])) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (chars[i] - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (chars[i] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + prefix * (chars[i] - '0');
            i++;

        }
        return result;
    }

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("-2147483647"));
    }
}
