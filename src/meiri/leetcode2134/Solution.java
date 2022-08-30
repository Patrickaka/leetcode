package meiri.leetcode2134;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, ans = n;
        int[] sum = new int[n * 2 + 2];
        for (int i = 1; i < n * 2 + 2; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1 + n) % n];
        }
        int len = sum[n];
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, len - (sum[i + len - 1] - sum[i - 1]));
        }
        return ans;
    }
}