package meiri.leetcode382;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {

    List<Integer> list = new ArrayList<>();
    int n;
    Random random = new Random();

    public Solution(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        n = list.size();
    }

    public int getRandom() {
        return list.get(random.nextInt(n));
    }

    public static class ListNode {
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
}