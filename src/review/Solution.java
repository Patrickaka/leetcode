package review;


class Solution {


    int[] ans;
    int sum;

    public int[] reversePrint(ListNode head) {
        dfs(head);
        return ans;
    }

    void dfs(ListNode head) {
        sum++;
        if (head.next != null) {
            dfs(head.next);
        }
        if (head.next == null) {
            ans = new int[sum];
            sum = 0;
        }
        ans[sum++] = head.val;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}