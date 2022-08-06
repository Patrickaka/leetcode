package offer.offer37;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {

    TreeNode emptyNode = new TreeNode(2000);

    public static void main(String[] args) {
        Codec solution = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = solution.serialize(root);
        solution.deserialize(data);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("null");
            return sb.toString();
        }
        int cnt = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        cnt++;
        while (!deque.isEmpty() && cnt > 0) {
            TreeNode node = deque.pollFirst();
            sb.append(node.val).append(",");
            if (node.equals(emptyNode)) {
                continue;
            }
            cnt--;
            if (node.left != null) {
                cnt++;
                deque.addLast(node.left);
            } else {
                deque.addLast(emptyNode);
            }
            if (node.right != null) {
                cnt++;
                deque.addLast(node.right);
            } else {
                deque.addLast(emptyNode);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if ("null".equals(data)) {
            return null;
        }

        String[] ss = data.split(",");
        int n = ss.length;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        for (int i = 1; i < n; i += 2) {
            TreeNode poll = d.pollFirst();
            if (!"2000".equals(ss[i])) {
                int a = Integer.parseInt(ss[i]);
                poll.left = new TreeNode(a);
                d.addLast(poll.left);
            }
            if (i + 1 < n && !"2000".equals(ss[i + 1])) {
                int b = Integer.parseInt(ss[i + 1]);
                poll.right = new TreeNode(b);
                d.addLast(poll.right);
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }
    }
}
