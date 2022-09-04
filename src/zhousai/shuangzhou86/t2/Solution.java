package zhousai.shuangzhou86.t2;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            int num = n;
            Deque<Integer> deque = new ArrayDeque<>();
            while (num > 0) {
                deque.addLast(num % i);
                num /= i;
            }
            while (deque.size() > 1) {
                int a = deque.pollFirst(), b = deque.pollLast();
                if (a != b) {
                    return false;
                }
            }
        }
        return true;
    }
}