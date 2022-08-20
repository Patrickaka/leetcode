package offer.offer22;


/**
 * 链表中倒数第k个节点
 */
class Solution {

    /**
     * 快慢指针
     *
     * @param head 输入一个链表
     * @param k    倒数第k个节点
     * @return 倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        while (node != null) {
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