package review.meiri.leetcode735;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = {5, -5};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int t : asteroids) {
            boolean ok = true;
            while (ok && !deque.isEmpty() && deque.peekLast() > 0 && t < 0) {
                int a = Math.abs(deque.peekLast()), b = Math.abs(t);
                if (a <= b) {
                    deque.pollLast();
                }
                if (a >= b) {
                    ok = false;
                }
            }
            if (ok) {
                deque.addLast(t);
            }
        }
        int size = deque.size();
        int[] ans = new int[size];
        while (!deque.isEmpty()) {
            ans[--size] = deque.pollLast();
        }
        return ans;
    }
}