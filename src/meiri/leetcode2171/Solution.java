package meiri.leetcode2171;

import java.util.Arrays;

class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long a = 0, b = 0;
        for (int i = 1; i < n; i++) {
            b += beans[i] - beans[0];
        }
        long ans = a + b;
        for (int i = 1; i < n; i++) {
            a += beans[i - 1];
            b -= (long) (n - i) * (beans[i] - beans[i - 1]);
            ans = Math.min(a + b, ans);
        }
        return ans;
    }
}