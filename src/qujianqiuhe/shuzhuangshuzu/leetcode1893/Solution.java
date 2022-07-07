package qujianqiuhe.shuzhuangshuzu.leetcode1893;

class Solution {

    int n = 55;
    int[] tr = new int[n];

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int v) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tr[i];
        }
        return ans;
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int[] range : ranges) {
            int a = range[0];
            int b = range[1];
            for (int j = a; j <= b; j++) {
                add(j, 1);
            }
        }
        for (int i = left; i <= right; i++) {
            if (query(i) - query(i - 1) == 0) {
                return false;
            }
        }
        return true;
    }

}