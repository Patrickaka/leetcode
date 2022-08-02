package offer.offerII29;

class Solution {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node ans = new Node(Integer.MAX_VALUE);
            ans.next = ans;
            return ans;
        }
        Node ans = head;
        Node min = head;
        while (true) {
            if (head.next.val < min.val) {

                min = head;
                System.out.println(min.val);
            }
            if (head.val <= insertVal && head.next.val >= insertVal) {
                head.next = new Node(insertVal, head.next);
                return ans;
            }
            if (head.next.equals(ans)) {
                min.next = new Node(insertVal, min);
                return ans;
            }
            head = head.next;
        }
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}