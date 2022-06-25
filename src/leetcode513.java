import java.util.ArrayDeque;
import java.util.Deque;

class Solution513 {

    int max, ans;

//    public int findBottomLeftValue(TreeNode root) {
//        dfs(root,1);
//        return ans;
//    }

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans = deque.peek().val;
            while (size-- > 0) {
                TreeNode poll = deque.pollFirst();
                if (poll.left != null) {
                    deque.addLast(poll.left);
                }
                if (poll.right != null) {
                    deque.addLast(poll.right);
                }
            }
        }
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > max) {
            max = depth;
            ans = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }


}