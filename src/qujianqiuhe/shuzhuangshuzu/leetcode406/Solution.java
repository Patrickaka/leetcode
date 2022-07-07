package qujianqiuhe.shuzhuangshuzu.leetcode406;

import java.util.Arrays;

class Solution {
    int n;
    int[] tr;

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int v) {
        int ans = 0;
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

    public int[][] reconstructQueue(int[][] people) {
        n = people.length;
        tr = new int[n + 1];
        int[][] ans = new int[n][2];
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        for (int[] p : people) {
            int h = p[0], k = p[1];
            int l = 1, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (mid - query(mid) >= k + 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[r - 1] = p;
            add(r, 1);
        }
        return ans;
    }
}