import java.util.Arrays;

public class reverse_words_in_a_string {
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i].isEmpty()) continue;
            sb.append(arr[i]);
            sb.append(" ");
        }
        String result = sb.toString();
        result = result.substring(0,result.length()-1);//去除最后一个空格
        return result;

    }

    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));
    }
}
