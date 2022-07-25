package tulun.leetcode919;

import java.util.ArrayDeque;
import java.util.Deque;

class CBTInserter {

    int idx = 0;
    TreeNode root;
    TreeNode[] tr = new TreeNode[5000];

    public CBTInserter(TreeNode root) {

        this.root = root;
        tr[idx++] = root;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll.left != null) {
                deque.add(poll.left);
                tr[idx++] = poll.left;
            }
            if (poll.right != null) {
                deque.add(poll.right);
                tr[idx++] = poll.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        CBTInserter cbtInserter = new CBTInserter(t);
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
    }

    public int insert(int val) {
        int temp = idx;
        tr[idx++] = new TreeNode(val);
        if (temp % 2 == 1) {
            tr[(temp - 1) / 2].left = tr[temp];
            return tr[(temp - 1) / 2].val;
        } else {
            tr[(temp - 2) / 2].right = tr[temp];
            return tr[(temp - 2) / 2].val;
        }
    }

    public TreeNode get_root() {
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
