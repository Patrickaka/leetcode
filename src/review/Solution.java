package review;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int length = bookings.length;
        int[] cs = new int[n + 1];
        for (int[] book : bookings) {
            int v = book[2];
            cs[book[0]] += v;
            cs[book[1] + 1] -= v;
        }
        int[] ans = new int[n];
        ans[0] = cs[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + cs[i];
        }
        return ans;
    }
}