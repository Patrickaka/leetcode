class MyCalendarTwo {

    static int N = (int) 1e9;
    Node root = new Node();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        int ans = query(root, 0, N - 1, start, end - 1);
        if (ans >= 2) {
            return false;
        }
        update(root, 0, N - 1, start, end - 1, 1);
        return true;
    }

    void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.val += node.add;
        node.left.add += node.add;
        node.right.val += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.add += val;
            node.val += val;
            return;
        }
        pushDown(node);
        int mid = start + end >> 1;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (mid < r) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pushUp(node);
    }

    int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }
        pushDown(node);
        int mid = start + end >> 1, ans1 = 0, ans2 = 0;
        if (l <= mid) {
            ans1 = query(node.left, start, mid, l, r);
        }
        if (mid < r) {
            ans2 = query(node.right, mid + 1, end, l, r);
        }
        return Math.max(ans1, ans2);
    }

    private static class Node {
        Node left, right;
        int val, add;
    }
}