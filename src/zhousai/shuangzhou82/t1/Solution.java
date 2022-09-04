package zhousai.shuangzhou82.t1;

class Solution {

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    boolean dfs(TreeNode root) {
        if (root.left != null) {
            boolean a = dfs(root.left);
            boolean b = dfs(root.right);
            return root.val == 2 ? (a || b) : (a && b);
        } else {
            return root.val != 0;
        }
    }

    public static class TreeNode {
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