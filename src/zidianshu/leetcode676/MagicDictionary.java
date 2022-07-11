package zidianshu.leetcode676;

class MagicDictionary {

    TreeNode root;

    public MagicDictionary() {
        root = new TreeNode();
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "hallo", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }

    void add(String str) {
        TreeNode node = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (node.tr[idx] == null) {
                node.tr[idx] = new TreeNode();
            }
            node = node.tr[idx];
        }
        node.end = true;
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            add(str);
        }
    }

    public boolean search(String searchWord) {
        return query(searchWord, 0, root, 1);
    }

    private boolean query(String searchWord, int i, TreeNode node, int limit) {
//        System.out.println(searchWord + i + limit);
        if (limit < 0) {
            return false;
        }
        if (i == searchWord.length()) {
            return node.end && limit == 0;
        }
        int idx = searchWord.charAt(i) - 'a';
        for (int j = 0; j < 26; j++) {
            if (node.tr[j] == null) {
                continue;
            }
            if (query(searchWord, i + 1, node.tr[j], idx == j ? limit : limit - 1)) {
                return true;
            }
        }
        return false;
    }

    static class TreeNode {
        TreeNode[] tr = new TreeNode[26];
        boolean end;
    }
}