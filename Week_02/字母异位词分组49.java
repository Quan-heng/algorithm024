import java.util.*;

public class 字母异位词分组49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        //思路, HashMap, key为排序后的值，value->List<String>,sort后与key相同。
        Map<String, List<String>> map = new HashMap<>();
        List<String> subList;
        String temp;
        char[] strArr;
        for (int i = 0; i < strs.length; i++) {
            temp = strs[i];
            strArr = temp.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = String.valueOf(strArr);
            subList = map.getOrDefault(sortedStr, new ArrayList<>());
            subList.add(temp);
            map.put(sortedStr, subList);
        }
        return  new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{""};
        System.out.println((groupAnagrams(strs)));
    }


}
