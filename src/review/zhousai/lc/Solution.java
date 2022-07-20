package review.zhousai.lc;

class Solution {

    public TreeNode pruneTree(TreeNode root) {
        boolean ok = dfs(root);
        return root.val == 0 && ok ? null : root;
    }

    boolean dfs(TreeNode node) {
        boolean l = true, r = true;
        if (node.left != null) {
            l = dfs(node.left);
            if (l) {
                node.left = null;
            }
        }
        if (node.right != null) {
            r = dfs(node.right);
            if (r) {
                node.right = null;
            }
        }
        return node.val == 0 && l && r;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}