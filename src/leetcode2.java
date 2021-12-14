import java.util.Optional;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x1 = 0, x2 = 0, ans = 0, flag = 0;
        ListNode listNode = null;
        x1 = Optional.of(l1.val).orElse(0);
        x2 = Optional.of(l2.val).orElse(0);
        ans = x1 + x2 + flag;
        if (x1 + x2 >= 10) {
            listNode = new ListNode(ans % 10);
            flag = 1;
        } else {
            listNode = new ListNode(ans);
        }
        l1 = l1.next;
        l2 = l2.next;
        ListNode now = listNode;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                x1 = l1.val;
            } else {
                x1 = 0;
            }
            if (l2 != null) {
                x2 = l2.val;
            } else {
                x2 = 0;
            }
            ans = x1 + x2 + flag;
            flag = 0;
            if (x1 + x2 >= 10) {
                now.next = new ListNode(ans % 10);
                flag = 1;
            } else {
                now.next = new ListNode(ans);
            }
            now = now.next;
            if (l1 != null && l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = null;
            }
            if (l2 != null && l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = null;
            }
        }
        return listNode;
    }

    public static void main(String[] args) {
        System.out.println(10 % 10);
    }
}