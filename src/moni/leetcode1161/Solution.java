package moni.leetcode1161;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int max = root.val, ans = 1, idx = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode node = deque.pollFirst();
                sum += node.val;
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            System.out.println(sum + " " + max);
            if (sum > max) {
                max = sum;
                ans = idx;
            }
            idx++;
        }
        return ans;
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