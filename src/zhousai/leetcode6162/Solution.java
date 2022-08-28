package zhousai.leetcode6162;

class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {

        int a = 0, b = 0, c = 0;
        int ans = 0;
        int n = garbage.length;
        int[] sums = new int[n];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + travel[i - 1];
        }
        for (int idx = 0; idx < garbage.length; idx++) {
            String str = garbage[idx];
            int m = 0, p = 0, g = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'M') {
                    m++;
                } else if (str.charAt(i) == 'P') {
                    p++;
                } else if (str.charAt(i) == 'G') {
                    g++;
                }
            }
            ans += m;
            ans += p;
            ans += g;
            if (m != 0) {
                ans += sums[idx] - sums[a];
                a = idx;
            }
            if (p != 0) {
                ans += sums[idx] - sums[b];
                b = idx;
            }
            if (g != 0) {
                ans += sums[idx] - sums[c];
                c = idx;
            }
        }
        return ans;
    }
}