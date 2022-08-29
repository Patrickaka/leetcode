package meiri.leetcode998;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 */
class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode res = new TreeNode(val);
        if (root.val < val) {
            res.left = root;
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node.right != null) {
                deque.add(node.right);
                if (node.val > val && node.right.val < val) {
                    res.left = node.right;
                    node.right = res;
                    return root;
                }
            }
            if (deque.isEmpty()) {
                node.right = res;
            }
        }
        return root;
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