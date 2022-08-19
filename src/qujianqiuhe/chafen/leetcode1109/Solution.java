package qujianqiuhe.chafen.leetcode1109;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2], ans = new int[n];
        for (int[] book : bookings) {
            int a = book[0], b = book[1], c = book[2];
            diff[a] += c;
            diff[b + 1] -= c;
        }
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}