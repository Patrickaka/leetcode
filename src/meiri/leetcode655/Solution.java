package meiri.leetcode655;

import java.util.*;

class Solution {

    String[][] res;
    int height = 0;

    public List<List<String>> printTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            height++;
            while (size-- > 0) {
                TreeNode poll = deque.pollFirst();
                assert poll != null;
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
        }
        int m = height + 1, n = (int) (Math.pow(2, height + 1) - 1);
        int mid = (n - 1) / 2;
        res = new String[m][n];
        for (String[] str : res) {
            Arrays.fill(str, "");
        }
        dfs(root, 0, mid);
        List<List<String>> ans = new ArrayList<>();
        for (String[] str : res) {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, str);
            ans.add(list);
        }
        return ans;
    }

    void dfs(TreeNode node, int x, int y) {
        res[x][y] = String.valueOf(node.val);
        if (node.left != null) {
            dfs(node.left, x + 1, (int) (y - Math.pow(2, height - x - 1)));
        }
        if (node.right != null) {
            dfs(node.right, x + 1, (int) (y + Math.pow(2, height - x - 1)));
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