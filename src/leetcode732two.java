class MyCalendarThreeTwo {

    static int N = (int) 1e9;
    Node root = new Node();

    public MyCalendarThreeTwo() {

    }

    private void pushUp(Node node) {
        node.val = Math.max(node.left.val, node.right.val);
    }

    private void pushDown(Node node) {
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
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    private void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pushUp(node);
    }

    public int book(int start, int end) {
        update(root, 0, N, start, end - 1, 1);
        return root.val;
    }

    private static class Node {
        Node left, right;
        int val, add;
    }
}
