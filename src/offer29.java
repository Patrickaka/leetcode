class SolutionOffer29 {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        node.next = node;
        if (head == null) {
            return node;
        }
        Node ans = head;
        int min = head.val, max = head.val;
        while (head.next != ans) {
            head = head.next;
            min = Math.min(min, head.val);
            max = Math.max(max, head.val);
        }
        if (min == max) {
            node.next = ans.next;
            ans.next = node;
        } else {
            while (!(head.val == max && head.next.val == min)) {
                head = head.next;
            }
            while (!(insertVal <= min || insertVal >= max) && !(head.val <= insertVal && insertVal <= head.next.val)) {
                head = head.next;
            }
            node.next = head.next;
            head.next = node;
        }
        return ans;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            val = val;
        }

        public Node(int val, Node next) {
            val = val;
            next = next;
        }
    }
}

