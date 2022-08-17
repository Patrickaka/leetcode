package offer.offerII67;

class Solution {

    Trie root = new Trie();

    void add(int x) {
        Trie node = root;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (node.tri[u] == null) {
                node.tri[u] = new Trie();
            }
            node = node.tri[u];
        }
    }

    int getVal(int num) {
        Trie node = root;
        int xorNum = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (num >> i) & 1;
            int t = (u - 1) * -1;
            if (node.tri[t] == null) {
                node = node.tri[u];
                xorNum = xorNum * 2 + u;
            } else {
                node = node.tri[t];
                xorNum = xorNum * 2 + t;
            }
        }
        return xorNum ^ num;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            add(num);
            ans = Math.max(ans, getVal(num));
        }
        return ans;
    }

    static class Trie {
        Trie[] tri = new Trie[2];
    }
}