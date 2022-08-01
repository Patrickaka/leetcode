package offerII.offerII22;


class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k - 1; i++) {
            node = node.next;
        }
        while (node.next != null) {
            node = node.next;
            head = head.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}