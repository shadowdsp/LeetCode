class Trie {
    class TreeNode {
        boolean vis;
        TreeNode []next;
        
        public TreeNode() {
            this.next = new TreeNode[26];
        }
    }
    TreeNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int n = word.length();
        TreeNode cur = root;
        for (int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null) {
                cur.next[c] = new TreeNode();
            }
            cur = cur.next[c];
        }
        cur.vis = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null) return false;
            cur = cur.next[c];
        }
        return cur.vis;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            int c = prefix.charAt(i) - 'a';
            if (cur.next[c] == null) return false;
            cur = cur.next[c];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */