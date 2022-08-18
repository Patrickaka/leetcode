package dp.leetcode55;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        var dp = new boolean[n];
        dp[n - 1] = true;
        int cnt = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= n - 1) {
                cnt = i;
                dp[i] = true;
            } else if (nums[i] + i >= cnt) {
                cnt = i;
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}