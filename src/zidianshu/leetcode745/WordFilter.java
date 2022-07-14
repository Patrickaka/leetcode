package zidianshu.leetcode745;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class WordFilter {

    Trie root = new Trie();
    Trie root2 = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String reWord = reversrent(words[i]);
            add(words[i], i, 1);
            add(reWord, i, 2);
        }
    }

    public static void main(String[] args) {
        String[] words = {"abbba", "abba"};
        String pref = "ab", suff = "ba";
        WordFilter obj = new WordFilter(words);
        int param_1 = obj.f(pref, suff);
        System.out.println(param_1);
    }

    void add(String str, int index, int type) {
        Trie node = type == 1 ? root : root2;
        for (int i = 0; i < str.length(); i++) {
            node.lists.add(index);
            int u = str.charAt(i) - 'a';
            if (node.tr[u] == null) {
                node.tr[u] = new Trie();
            }
            node = node.tr[u];
        }
        node.end = true;
        node.lists.add(index);
    }

    String reversrent(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public int f(String pref, String suff) {
        Trie node = root;
        for (int i = 0; i < pref.length(); i++) {
            int u = pref.charAt(i) - 'a';
            if (node.tr[u] == null) {
                return -1;
            }
            node = node.tr[u];
        }
        List<Integer> l1 = node.lists;
        node = root2;
        String reSuff = reversrent(suff);
        for (int i = 0; i < reSuff.length(); i++) {
            int u = reSuff.charAt(i) - 'a';
            if (node.tr[u] == null) {
                return -1;
            }
            node = node.tr[u];
        }
        List<Integer> l2 = node.lists;
        for (int i = l1.size() - 1, j = l2.size() - 1; i >= 0 && j >= 0; ) {
            if (Objects.equals(l1.get(i), l2.get(j))) {
                return l1.get(i);
            }
            if (l1.get(i) >= l2.get(j)) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    static class Trie {
        Trie[] tr = new Trie[26];
        List<Integer> lists = new ArrayList<>();
        boolean end;
    }
}