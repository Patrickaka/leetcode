package meiri.leetcode623;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int k = depth - 1;
        if (k == 0) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        k--;
        while (!deque.isEmpty() && k-- > 0) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
        }
        for (TreeNode tr : deque) {
            TreeNode l = tr.left;
            TreeNode r = tr.right;
            tr.left = new TreeNode(val);
            tr.left.left = l;
            tr.right = new TreeNode(val);
            tr.right.right = r;
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