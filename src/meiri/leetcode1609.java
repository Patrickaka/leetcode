package meiri;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
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

class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        boolean flag = true;
        d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            int prev = flag ? 0 : 0x3f3f3f;
            while (size-- > 0) {
                TreeNode treeNode = d.pollFirst();
                int cur = treeNode.val;
                if (flag && (cur % 2 == 0 || cur <= prev)) {
                    return false;
                }
                if (!flag && (cur % 2 != 0 || cur >= prev)) {
                    return false;
                }
                prev = cur;
                if (treeNode.left != null) {
                    d.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    d.addLast(treeNode.right);
                }
            }
            flag = !flag;
        }
        return true;
    }
}