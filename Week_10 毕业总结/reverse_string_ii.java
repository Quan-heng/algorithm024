public class reverse_string_ii {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(start + k - 1, s.length() - 1);
            while (start < end) {
                char temp = charArray[start];
                charArray[start++] = charArray[end];
                charArray[end--] = temp;
            }
        }
        return String.valueOf(charArray);
    }
}
