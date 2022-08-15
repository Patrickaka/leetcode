package dp.leetcode1137;

class Solution {
    public int tribonacci(int n) {
        if (n <= 2) {
            return n >= 1 ? 1 : 0;
        }
        int p = 0, q = 1, r = 1;
        for (int i = 3; i <= n; i++) {
            int m = p + q + r;
            p = q;
            q = r;
            r = m;
        }
        return r;
    }
}