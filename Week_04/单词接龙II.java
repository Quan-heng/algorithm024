import java.util.*;

/**
 * 解题思路：BFS
 * 在单词接龙的基础上，需要将找到的最短路径存储下来；
 * 队列里保存相差为1的字符串列表，每次取出各列表中最后一个元素，一直到当前元素与终点元素相同。
 */

public class 单词接龙II {
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(findLadders(begin, end, wordList));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (beginWord.isEmpty() || endWord.isEmpty() || beginWord.length() != endWord.length() || !wordList.contains(endWord)) {
            return result;
        }
        wordList.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);//判断元素是否存在的时间复杂度降为O(1)
        Set<String> visited = new HashSet<>();//下层不需要访问已经保存在路径中的元素
        Deque<Deque<String>> queue = new LinkedList<>();
        Deque<String> list = new LinkedList<>();
        list.add(beginWord);
        queue.add(list);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Boolean find = false;
            List<String> visitList = new ArrayList<>();//保存当前层符合条件的字符串
            for (int i = 0; i < size; i++) {
                Deque<String> curList = queue.pop();
                String curWord = curList.getLast();//获取尾元素
                //从wordSet中获取与当前元素相差一个字符的字符串
                List<String> diffList = getDiffWord(curWord, wordSet);
                for (String s : diffList) {
                    if (!visited.contains(s)) {
                        visitList.add(s);
                        if (s.equals(endWord)) {
                            find = true;
                            curList.add(s);
                            result.add(new ArrayList<>(curList));
                        } else {
                            Deque<String> newList = new LinkedList<>(curList);
                            newList.add(s);//将符合条件的元素放在当前列表尾部
                            queue.add(newList);//将列表重新放回队列
                        }
                    }
                }
            }
            visited.addAll(visitList);
            if (find) {//在当前层找到终点元素,没必要进行后面的查询
                break;
            }
        }
        return result;
    }

    private static List<String> getDiffWord(String curWord, Set<String> wordSet) {
        char[] charArray = curWord.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            char old = charArray[i];
            for (int j = 'a'; j <= 'z'; j++) {
                charArray[i] = (char) j;
                if (j == old) {
                    continue;
                }
                String temp = String.valueOf(charArray);
                if (wordSet.contains(temp)) {
                    list.add(temp);
                }
            }
            charArray[i] = old;
        }
        return list;
    }
}
