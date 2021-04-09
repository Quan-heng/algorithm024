public class valid_palindrome_ii {
    public static int diffCount = 0;

    /**
     * 递归
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length-1;
        while(start<end){
            if(chars[start]==chars[end]){
                start++;
                end--;
            }else{
                if(diffCount==0){
                    diffCount++;
                    return validPalindrome(s.substring(start,end))||validPalindrome(s.substring(start+1,end+1));
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println("abc".substring(0,2));
        System.out.println(validPalindrome("abca"));
    }
}
