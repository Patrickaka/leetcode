package meiri.leetcode641;

class MyCircularDeque {

    int k, cnt = 0;
    Node root = null;

    public MyCircularDeque(int k) {
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (cnt >= k) {
            return false;
        }
        cnt++;
        if (root == null) {
            root = new Node(value);
            root.next = root;
            root.prev = root;
            return true;
        }
        Node newNode = new Node(value);
        newNode.next = root;
        newNode.prev = root.prev;
        root.prev.next = newNode;
        root.prev = newNode;
        root = newNode;
        return true;
    }

    public boolean insertLast(int value) {
        if (cnt >= k) {
            return false;
        }
        cnt++;
        if (root == null) {
            root = new Node(value);
            root.next = root;
            root.prev = root;
            return true;
        }
        Node newNode = new Node(value);
        newNode.next = root;
        newNode.prev = root.prev;
        root.prev.next = newNode;
        root.prev = newNode;
        return true;
    }

    public boolean deleteFront() {
        if (root == null || cnt == 0) {
            return false;
        }
        cnt--;
        if (cnt == 0) {
            root = null;
            return true;
        }
        Node del = root;
        root.prev.next = del.next;
        del.next.prev = del.prev;
        root = del.next;
        return true;
    }

    public boolean deleteLast() {
        if (root == null || cnt == 0) {
            return false;
        }
        cnt--;
        if (cnt == 0) {
            root = null;
            return true;
        }
        Node del = root.prev;
        del.prev.next = root;
        root.prev = del.prev;
        return true;
    }

    public int getFront() {
        if (root == null || cnt == 0) {
            return -1;
        }
        return root.val;
    }

    public int getRear() {
        if (root == null || cnt == 0) {
            return -1;
        }
        return root.prev.val;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }

    static class Node {
        int val;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}