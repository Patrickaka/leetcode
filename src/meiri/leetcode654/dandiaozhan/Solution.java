package meiri.leetcode654.dandiaozhan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    /**
     * 单调栈做法
     * 起始创建一个根节点 其中包含一个数组 数组内包含所有元素
     * 之后任意选择一个包含数组的节点 取出最大值 然后最大值左侧的放到左节点 右侧的放到右节点
     * 等价于找到每一个节点左侧和右侧的最大元素--转换为单调栈问题
     *
     * @param nums 给定一个不重复的整数数组
     * @return 由nums构建的完整二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        var n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        var lmax = new int[n];
        var rmax = new int[n];
        Arrays.fill(lmax, -1);
        Arrays.fill(rmax, -1);

        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new TreeNode(nums[i]);
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                rmax[deque.pollLast()] = i;
            }
            if (!deque.isEmpty()) {
                lmax[i] = deque.peekLast();
            }
            deque.addLast(i);
        }

        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (lmax[i] == -1 && rmax[i] == -1) {
                root = tree[i];
            } else if (rmax[i] == -1 || (lmax[i] != -1 && nums[lmax[i]] < nums[rmax[i]])) {
                tree[lmax[i]].right = tree[i];
            } else {
                tree[rmax[i]].left = tree[i];
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