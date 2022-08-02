package offer.offer52;

class Solution {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ta = headA, tb = headB;
        while (ta != tb) {
            ta = ta == null ? headB : ta.next;
            tb = tb == null ? headA : tb.next;
        }
        return ta;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}