public class reverse_words_in_a_string_iii {
    public String reverseWords(String s) {
        String[] wordArr = s.split(" ");
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < wordArr.length; i++) {
            char[] chars = wordArr[i].toCharArray();
            int start = 0;
            int end = chars.length-1;
            while(start<end){
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
            sb.append(chars);
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0,result.length()-1);
    }
}
