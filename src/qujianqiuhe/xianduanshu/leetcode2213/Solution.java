package qujianqiuhe.xianduanshu.leetcode2213;

class Solution {

    static int N = (int) 1e5;
    Node root = new Node();
    char[] cs;

    void build(Node node, int l, int r) {
        node.ls = new Node();
        node.rs = new Node();
        if (l == r) {
            return;
        }
        int mid = l + r >> 1;
        if (l >= r) {
            build(node.ls, l, mid);
        } else {
            build(node.rs, mid + 1, r);
        }
    }

    void update(Node node, int start, int end, int x, char c) {
        if (start <= x && x <= end) {
            cs[x] = c;
            return;
        }
        int mid = start + end >> 1;
//        if()
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int[] ans = new int[queryIndices.length];
        cs = s.toCharArray();
        char[] s2 = queryCharacters.toCharArray();
        return ans;
    }

    static class Node {
        Node ls, rs;
        int val, prefix, suffix;

        public Node() {
            this.val = this.prefix = this.suffix = 1;
        }

        public Node(Node ls, Node rs) {
            this.ls = ls;
            this.rs = rs;
            this.val = this.prefix = this.suffix = 1;
        }
    }
}