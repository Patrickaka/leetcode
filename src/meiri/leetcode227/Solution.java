package meiri.leetcode227;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = cs.length;
        Deque<Integer> nums = new ArrayDeque<>();
        nums.add(0);
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNumber(cs[j])) {
                        u = u * 10 + (cs[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '+' || cs[i - 1] == '-' || cs[i - 1] == '(')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
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
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '%') {
            ans = a % b;
        } else if (op == '^') {
            ans = (int) Math.pow(a, b);
        }
        nums.addLast(ans);
    }

    boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}