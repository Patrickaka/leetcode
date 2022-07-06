package tulun.leetcode736.dfs;

import java.util.HashMap;

class Solution {

    char[] cs;
    String s;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String exp = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        System.out.println(solution.evaluate(exp));
    }

    public int evaluate(String expression) {
        s = expression;
        cs = s.toCharArray();
        return dfs(0, cs.length - 1, new HashMap<>());
    }

    private int dfs(int l, int r, HashMap<String, Integer> map) {
        System.out.println(s.substring(l, r));
        if (cs[l] == '(') {
            int idx = l;
            while (cs[idx] != ' ') {
                idx++;
            }
            String op = s.substring(l + 1, idx);
            r--;
            if (op.equals("let")) {
                for (int i = idx + 1; i <= r; ) {
                    int j = getRight(i, r);
                    String key = s.substring(i, j);
                    if (j >= r) {
                        return dfs(i, j - 1, new HashMap<>(map));
                    }
                    j++;
                    i = j;
                    j = getRight(i, r);
                    int value = dfs(i, j - 1, new HashMap<>(map));
                    map.put(key, value);
                    i = j + 1;
                }
                return -1;
            } else if (op.equals("add")) {
                int j = getRight(idx + 1, r);
                int a = dfs(idx + 1, j - 1, new HashMap<>(map));
                int b = dfs(j + 1, r, new HashMap<>(map));
                return a + b;
            } else {
                int j = getRight(idx + 1, r);
                int a = dfs(idx + 1, j - 1, new HashMap<>(map));
                int b = dfs(j + 1, r, new HashMap<>(map));
                return a * b;
            }
        } else {
            String cur = s.substring(l, r + 1);
            if (map.containsKey(cur)) {
                return map.get(cur);
            }
            return Integer.parseInt(cur);
        }
    }

    private int getRight(int l, int r) {
        int right = l, score = 0;
        while (right <= r) {
            if (cs[right] == '(') {
                score++;
                right++;
            } else if (cs[right] == ')') {
                score--;
                right++;
            } else if (cs[right] == ' ') {
                if (score == 0) {
                    break;
                }
                right++;
            } else {
                right++;
            }
        }
        return right;
    }

}