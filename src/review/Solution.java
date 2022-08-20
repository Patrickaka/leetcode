package review;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        int idx = 0;
        Node res = new Node(head.val);
        map.put(idx++, res);
        Node newNode = res;
        Node t = head;
        while (t.next != null) {
            t = t.next;
            Node node = new Node(t.val);
            map.put(idx++, node);
            newNode.next = node;
            newNode = newNode.next;
        }
        t = head;
        idx = 0;
        while (t != null) {
            map.get(idx).random = t.random == null ? null : map.get(t.random.val);
            t = t.next;
        }
        return res;
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