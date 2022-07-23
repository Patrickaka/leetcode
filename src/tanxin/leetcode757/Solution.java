package tanxin.leetcode757;

import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] ins) {
        Arrays.sort(ins, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int a = -1, b = -1, ans = 0;
        for (int[] i : ins) {
            if (i[0] > b) {
                a = i[1] - 1;
                b = i[1];
                ans += 2;
            } else if (i[0] > a) {
                a = b;
                b = i[1];
                ans++;
            }
        }
        return ans;
    }
}
