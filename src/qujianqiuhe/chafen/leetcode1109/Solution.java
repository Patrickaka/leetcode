package qujianqiuhe.chafen.leetcode1109;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] c = new int[n + 1];
        for (int[] booking : bookings) {
            int l = booking[0] - 1, r = booking[1] - 1, v = booking[2];
            c[l] += v;
            c[r + 1] -= v;
        }
        int[] ans = new int[n];
        ans[0] = c[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + c[i];
        }
        return ans;
    }
}