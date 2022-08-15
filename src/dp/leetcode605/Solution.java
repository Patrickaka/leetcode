package dp.leetcode605;

class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] f = new int[n + 1];
        int p = 0, q = 1;
        for (int i = 2; i < f.length; i++) {
            int r = p + q;
            p = q;
            q = r;
        }
        return q;
    }
}