import java.util.HashMap;
import java.util.Map;

public class valid_anagram {
    public boolean isAnagram(String s, String t) {
        if(s.isEmpty()||t.isEmpty()||s.length()!=t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i= 0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int count = map.getOrDefault(c,0);
            if(count==0){
                return false;
            }else if(count==1){
                map.remove(c);
            }
            else{
                map.put(c,count-1);
            }
        }
        return map.isEmpty();
    }
}
