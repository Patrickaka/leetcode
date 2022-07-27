package moni.leetcode224;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        nums.addLast(0);
        s = s.replaceAll(" ", "");
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    char op = ops.peekLast();
                    if (op != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNum((c))) {
                    int u = 0, j = i;
                    while (j < n && isNum(cs[j])) {
                        u = u * 10 + (cs[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        calc(nums, ops);
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);
    }

    boolean isNum(char c) {
        return Character.isDigit(c);
    }
}