package meiri;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class Solution589 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder1(Node root) {
        dfs(root);
        return ans;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        for (Node node : root.children) {
            dfs(node);
        }
    }

    public List<Integer> preorder(Node root) {
        Deque<Object[]> d = new ArrayDeque<>();
        d.addLast(new Object[]{root, 0});
        while (!d.isEmpty()) {
            Object[] objects = d.pollLast();
            Node node = (Node) objects[0];
            int cnt = (int) objects[1];
            if (cnt == 0) {
                ans.add(node.val);
            }
            if (cnt < node.children.size()) {
                d.addLast(new Object[]{node,cnt + 1});
                d.addLast(new Object[]{node.children.get(cnt),0});
            }
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};