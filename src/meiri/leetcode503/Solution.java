package meiri.leetcode503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    /**
     * 单调栈 -- 栈内元素满足单调性
     * 每次插入时保证单调性
     *
     * @param nums 给定一个循环数组
     * @return nums中每个元素的下一个更大元素
     */
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        var n = nums.length;
        var ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i % n]) {
                ans[deque.pollLast()] = nums[i % n];
            }
            deque.addLast(i % n);
        }
        return ans;
    }
}