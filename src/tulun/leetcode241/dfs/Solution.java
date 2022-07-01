package tulun.leetcode241.dfs;

import java.util.ArrayList;
import java.util.List;

class Solution {

    char[] chars;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("11"));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        chars = expression.toCharArray();
        return dfs(0, chars.length - 1);
    }

    List<Integer> dfs(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            }
            List<Integer> l1 = dfs(l, i - 1), l2 = dfs(i + 1, r);
            for (int a : l1) {
                for (int b : l2) {
                    int cur = 0;
                    if (chars[i] == '+') {
                        cur = a + b;
                    } else if (chars[i] == '-') {
                        cur = a - b;
                    } else {
                        cur = a * b;
                    }
                    result.add(cur);
                }
            }
        }
        if (result.isEmpty()) {
            int cur = 0;
            for (int i = l; i <= r; i++) {
                cur = (cur * 10 + (chars[i] - '0'));
            }
            result.add(cur);
        }
        return result;
    }
}