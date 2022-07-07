package qujianqiuhe.qianzhuihe;

import java.util.ArrayList;
import java.util.List;

class Solution15371537 {

    int MOD = (int) 1e9 + 7;

    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        long[] s1 = new long[n + 10], s2 = new long[m + 10];
        for (int i = 1; i <= n; i++) {
            s1[i] = s1[i - 1] + nums1[i - 1];
        }
        for (int i = 1; i <= m; i++) {
            s2[i] = s2[i - 1] + nums2[i - 1];
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (nums1[i] == nums2[j]) {
                list.add(new int[]{i, j});
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        long ans = 0;
        for (int i = 0, p1 = -1, p2 = -1; i <= list.size(); i++) {
            int idx1 = 0, idx2 = 0;
            if (i < list.size()) {
                int[] info = list.get(i);
                idx1 = info[0];
                idx2 = info[1];
            } else {
                idx1 = n - 1;
                idx2 = m - 1;
            }
            long t1 = s1[idx1 + 1] - s1[p1 + 1], t2 = s2[idx2 + 1] - s2[p2 + 1];
            ans += Math.max(t1, t2);
            p1 = idx1;
            p2 = idx2;
        }
        return (int) (ans % MOD);
    }
}