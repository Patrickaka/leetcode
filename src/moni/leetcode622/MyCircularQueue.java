package moni.leetcode622;

class MyCircularQueue {

    static int n;
    int cnt = 0;
    Node root = new Node();

    public MyCircularQueue(int k) {
        n = k;
        root.next = root;
        root.prev = root;
    }

    public boolean enQueue(int value) {
        if (cnt >= n) {
            return false;
        }
        cnt++;
        Node newNode = new Node(value);
        if (root.val == null) {
            root = newNode;
            root.next = root;
            root.prev = root;
        } else {
            newNode.prev = root.prev;
            newNode.next = root;
            root.prev.next = newNode;
            root.prev = newNode;
        }
        return true;
    }

    public boolean deQueue() {
        if (cnt <= 0) {
            return false;
        } else if (cnt == 1) {
            cnt--;
            root = new Node();
            return true;
        }
        cnt--;
        Node de = root;
        root = root.next;
        de.prev.next = root;
        root.prev = de.prev;
        return true;
    }

    public int Front() {
        return root.val == null ? -1 : root.val;
    }

    public int Rear() {
        return root.prev.val == null ? -1 : root.val;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == n;
    }

    static class Node {
        Integer val;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
