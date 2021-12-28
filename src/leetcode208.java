class Trie {

    Trie[] children = new Trie[26];
    boolean flag = false;

    public Trie() {
        Trie[] children = new Trie[26];
        boolean flag = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.flag = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return node.flag;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}