package meiri.leetcode654;

class Solution {

    int[] nums;
    boolean[] vis;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println(treeNode.toString());
    }

    /**
     * 递归
     *
     * @param nums 给定一个不重复的整数数组
     * @return 由nums构建的完整二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        var n = nums.length;
        vis = new boolean[n];
        return dfs(0, n - 1);
    }

    TreeNode dfs(int l, int r) {
        var max = -1;
        var idx = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        if (vis[idx]) {
            return null;
        }
        TreeNode node = new TreeNode(nums[idx]);
        vis[idx] = true;
        node.left = dfs(l, idx - 1);
        node.right = dfs(idx + 1, r);
        return node;
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