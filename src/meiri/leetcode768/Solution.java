package meiri.leetcode768;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() <= num) {
                deque.addLast(num);
            } else {
                int cnt = deque.pollLast();
                while (!deque.isEmpty() && deque.peekLast() > num) {
                    deque.pollLast();
                }
                deque.addLast(cnt);
            }
        }
        return deque.size();
    }
}