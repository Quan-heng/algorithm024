public class implement_trie_prefix_tree {
    class Trie {
        class TrieNode {
            private TrieNode[] links;
            public boolean isEnd;

            public TrieNode() {
                links = new TrieNode[26];
            }

            public void put(char c, TrieNode node) {
                if (!contains(c)) {
                    links[c - 'a'] = node;
                }
            }

            public boolean contains(char c) {
                return links[c - 'a'] != null;
            }

            public TrieNode get(char c) {
                return links[c - 'a'];
            }

            public void setEnd() {
                isEnd = true;
            }
        }

        /**
         * Initialize your data structure here.
         */
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode root = this.root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!root.contains(charArray[i])) {
                    root.put(charArray[i], new TrieNode());
                }
                root = root.get(charArray[i]);
            }
            root.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode root = this.root;
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
            TrieNode root = this.root;
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
}
