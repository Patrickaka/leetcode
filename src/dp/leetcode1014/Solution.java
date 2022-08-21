package dp.leetcode1014;

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int ans = 0;
        int prev = values[0];
        for (int i = 1; i < n; i++) {
            int cnt = Math.max(prev - values[i - 1] + values[i] - 1, values[i - 1] + values[i] - 1);
            prev = cnt;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}