package dp.leetcode213;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3};
        System.out.println(solution.rob(arr));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int a, b;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        a = dp[n - 1];
        dp = new int[n + 1];
        dp[1] = nums[1];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        b = dp[n - 1];
        return Math.max(a, b);
    }
}