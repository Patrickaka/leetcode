package offerII.offerII06;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        System.out.println(Arrays.toString(solution.reversePrint(n1)));
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int n = 1;
        ListNode root = new ListNode(head.val);
        while (head.next != null) {
            ListNode node = new ListNode(head.next.val);
            head = head.next;
            node.next = root;
            root = node;
            n++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = root.val;
            root = root.next;
        }
        return ans;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode() {

        }
    }
}