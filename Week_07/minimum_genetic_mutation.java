import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class minimum_genetic_mutation {
    /**
     * 解题思路：
     * 可以用dfs,单向bfs,双向bfs,这里用双向bfs
     * 核心代码
     * 1.判断beginSet与endSet是否相遇
     * 2.不断交换两个Set
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public static int minMutation(String start, String end, String[] bank) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(bank));
        if (!wordSet.contains(end)) return -1;
        wordSet.remove(start);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int result = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> newSet = new HashSet<>();
            for (String word : beginSet) {
                visited.add(word); //注意：visited位置容易放错
                if (endSet.contains(word)) {
                    return result;
                } else {
                    char[] charArray = word.toCharArray();
                    for (int i = 0; i < charArray.length; i++) {
                        char old = charArray[i];
                        for (char c = 'A'; c <= 'Z'; c++) {
                            if (c == old) continue;
                            charArray[i] = c;
                            String str = String.valueOf(charArray);
                            if (wordSet.contains(str) && !visited.contains(str)) {
                                newSet.add(str);
                            }
                        }
                        charArray[i] = old;
                    }
                }
            }
            beginSet = newSet;
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String begin = "AAAACCCC";
        String end = "CCCCCCCC";;
        String[] bank=new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(begin,end,bank));
    }
}
