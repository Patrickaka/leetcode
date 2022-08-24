package dp.leetcode42;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        if (height.length < 3) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peekLast()] < height[i]) {
                Integer poll = deque.pollLast();
                while (!deque.isEmpty() && height[poll] == height[deque.peekLast()]) {
                    deque.pollLast();
                }
                if (!deque.isEmpty()) {
                    ans += (Math.min(height[deque.peekLast()] - height[poll], height[i] - height[poll]) * (i - deque.peekLast() - 1));
                }
            }
            deque.add(i);
        }
        return ans;
    }
}