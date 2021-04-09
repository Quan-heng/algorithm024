public class reverse_words_in_string {
    public String reverseWords(String s) {
        String[] arr= s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i].isEmpty()) continue;
            sb.append(arr[i]);
            sb.append(" ");

        }
        String result = sb.toString();
        return result.substring(0,result.length()-1);
    }
}
