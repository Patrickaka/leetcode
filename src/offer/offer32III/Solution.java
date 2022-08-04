package offer.offer32III;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int i = 1;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            while (size-- > 0) {
                if (i == 1) {
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
            }
            i *= -1;
            ans.add(list);
        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}