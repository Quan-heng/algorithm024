import java.util.HashMap;
import java.util.Map;

public class first_unique_characer_in_a_string {
    /**
     * 解题思路：hashMap
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map  = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}
