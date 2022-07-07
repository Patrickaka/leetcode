package zidianshu.leetcode677.dfs;


class MapSum {

    TreeNode root = new TreeNode();

    public MapSum() {

    }

    public void insert(String key, int val) {
        TreeNode t = root;
        for (int i = 0; i < key.length(); i++) {
            int u = key.charAt(i) - 'a';
            if (t.tr[u] == null) {
                t.tr[u] = new TreeNode();
            }
            t = t.tr[u];
        }
        t.end = true;
        t.val = val;
    }

    public int sum(String prefix) {
        TreeNode t = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (t.tr[u] == null) {
                return 0;
            }
            t = t.tr[u];
        }
        return dfs(t);
    }

    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.end) {
            ans += node.val;
        }
        for (int i = 0; i < node.tr.length; i++) {
            if (node.tr[i] != null) {
                ans += dfs(node.tr[i]);
            }
        }
        return ans;
    }

    static class TreeNode {
        TreeNode[] tr = new TreeNode[26];
        boolean end;
        int val;
    }
}
