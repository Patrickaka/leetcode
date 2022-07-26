package review.meiri.lc;

class MyCalendarTwo {

    static int N = (int) 1e9;
    Node root = new Node();

    public MyCalendarTwo() {

    }

    void pushUp(Node node) {
        node.val = Math.max(node.ls.val, node.rs.val);
    }

    void pushDown(Node node) {
        if (node.ls == null) {
            node.ls = new Node();
        }
        if (node.rs == null) {
            node.rs = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.ls.add += node.add;
        node.rs.add += node.add;
        node.ls.val += node.val;
        node.rs.val += node.val;
        node.add = 0;
    }

    void update(Node node, int l, int r, int start, int end, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int mid = start + end >> 1;
        if (mid >= l) {
            update(node.ls, l, r, start, mid, val);
        }
        if (mid < r) {
            update(node.rs, l, r, mid + 1, end, val);
        }
        pushUp(node);
    }

    int query(Node node, int l, int r, int start, int end) {
        int lans = 0, rans = 0;
        if (l <= start && end <= r) {
            return node.val;
        }
        pushDown(node);
        int mid = start + end >> 1;
        if (mid >= l) {
            lans = query(node.ls, l, r, start, mid);
        }
        if (mid < r) {
            rans = query(node.rs, l, r, mid + 1, end);
        }
        return Math.max(lans, rans);
    }

    public boolean book(int start, int end) {
        if (query(root, start, end - 1, 0, N - 1) >= 2) {
            return false;
        }
        update(root, start, end - 1, 0, N - 1, 1);
        return true;
    }

    static class Node {
        Node ls, rs;
        int val;
        int add;
    }
}