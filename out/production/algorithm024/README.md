##3.双向BFS模板
>关键逻辑：两个Set（beginSet, endSet）,不断进行交换，先扩散Set size小的一边。一直到两个Set包含相同的元素。
```
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        int result = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> set = new HashSet<>();
            
            for (String s : beginSet) {
                char[] charArray = s.toCharArray();
                for (int j = 0; j < s.length(); j++) {
                    char old = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        charArray[j] = k;
                        String word = String.valueOf(charArray);
                        if (endSet.contains(word)) {
                            return result + 1;
                        }
                        if (wordSet.contains(word) && !visited.contains(word)) {
                            visited.add(word);
                            set.add(word);
                        }
                        charArray[j] = old;
                    }
                }
            }
            result++;
            beginSet = set;
        }
        return -1;
```
