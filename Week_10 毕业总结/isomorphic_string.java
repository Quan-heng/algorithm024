import java.util.HashMap;
import java.util.Map;

public class isomorphic_string {
    /**
     * app egg
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
       for(int i=0;i<s.length();i++){
           if (s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
               return false;
           }
       }
       return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
    }


}
