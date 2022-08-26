package meiri.leetcode662;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在 32 位 带符号整数范围内。
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        System.out.println(solution.widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(TreeNode root) {
        Deque<Object[]> deque = new ArrayDeque<>();
        deque.addLast(new Object[]{root, 1});
        int ans = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Object[] objects = deque.pollFirst();
                TreeNode poll = (TreeNode) objects[0];
                int idx = (int) objects[1];
                if (i == 0) {
                    first = idx;
                }
                if (i == size - 1) {
                    last = idx;
                }
                if (poll.left != null) {
                    deque.addLast(new Object[]{poll.left, idx * 2});
                }
                if (poll.right != null) {
                    deque.addLast(new Object[]{poll.right, idx * 2 + 1});
                }
            }
            ans = Math.max(last - first + 1, ans);
        }
        return ans;
    }

    static class TreeNode {
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