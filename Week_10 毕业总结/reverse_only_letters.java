public class reverse_only_letters {
    /**
     * 解题思路：
     * 双指针法
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start =0;
        int end = chars.length-1;
        while(start<end){
           if(!isLetter(chars[start])){
               start++;
               continue;
           }
           if(!isLetter(chars[end])){
               end--;
               continue;
           }
           char temp = chars[end];
           chars[end--] = chars[start];
           chars[start++] = temp;
        }
        return String.valueOf(chars);
    }

    public static boolean isLetter(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));

    }
}
