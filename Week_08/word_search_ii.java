import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_search_ii {
    static class Trie {
        class TrieNode {
            private Trie.TrieNode[] links;
            public boolean isEnd;

            public TrieNode() {
                links = new Trie.TrieNode[26];
            }

            public void put(char c, Trie.TrieNode node) {
                if (!contains(c)) {
                    links[c - 'a'] = node;
                }
            }

            public boolean contains(char c) {
                return links[c - 'a'] != null;
            }

            public Trie.TrieNode get(char c) {
                return links[c - 'a'];
            }

            public void setEnd() {
                isEnd = true;
            }
        }

        /**
         * Initialize your data structure here.
         */
        private Trie.TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie.TrieNode root = this.root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!root.contains(charArray[i])) {
                    root.put(charArray[i], new Trie.TrieNode());
                }
                root = root.get(charArray[i]);
            }
            root.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie.TrieNode root = this.root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!root.contains(charArray[i])) {
                    return false;
                }
                root = root.get(charArray[i]);
            }
            return root.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie.TrieNode root = this.root;
            char[] charArray = prefix.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!root.contains(charArray[i])) {
                    return false;
                }
                root = root.get(charArray[i]);
            }
            return true;
        }
    }

    public static int[] dx;
    public static int[] dy;
    public static Trie trie;

    public static List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        dx = new int[]{0, -1, 0, 1}; //左、上、右、下
        dy = new int[]{-1, 0, 1, 0};
        int i = 0;
        int j = 0;
        String word = "";
        Set<String> set = new HashSet<>();
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                dfs(set, m, n, "", wordSet, board, new HashSet<>());
            }
        }

        return new ArrayList<>(set);
    }

    private static void dfs(Set<String> set, int i, int j, String word, Set<String> wordSet, char[][] board, Set<String> visited) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited.contains(i + "," + j)) {
            return;
        }
        if (set.size() == wordSet.size()) {
            return;
        }
        word = word + board[i][j];
        if (wordSet.contains(word)) {
            set.add(word);
        }
        if (trie.startsWith(word)) {
            visited.add(i + "," + j);
            for (int k = 0; k < 4; k++) {
                dfs(set, i + dx[k], j + dy[k], word, wordSet, board, visited);
            }
            visited.remove(i + "," + j);
        } else {
            return;
        }
    }
}
