package offer.offer35;

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node t = head;
        while (t != null) {
            Node temp = new Node(t.val);
            temp.next = t.next;
            t.next = temp;
            t = t.next.next;
        }
        t = head;
        while (t != null) {
            if (t.random != null) {
                t.next.random = t.random.next;
            }
            t = t.next.next;
        }
        t = head.next;
        Node ans = head.next;
        while (t.next != null) {
            head.next = head.next.next;
            t.next = t.next.next;
            t = t.next;
            head = head.next;
        }
        head.next = null;
        return ans;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}