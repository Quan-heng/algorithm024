import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_ladder {
    /**
     * 解题思路：
     * 套用双向dfs模板
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        int result = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> newSet = new HashSet<>();
            for (String word : beginSet) {
                if (endSet.contains(word)) return result + 1;
                visited.add(word);
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == old) continue;
                        charArray[i] = j;
                        String str = String.valueOf(charArray);
                        if (wordSet.contains(str) && !visited.contains(str)) {
                            newSet.add(str);
                        }
                    }
                    charArray[i] = old;
                }
            }
            beginSet = newSet;
            result++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] wordArr = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength(begin,end, Arrays.asList(wordArr)));
    }
}
