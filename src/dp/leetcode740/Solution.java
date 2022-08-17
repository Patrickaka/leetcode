package dp.leetcode740;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 4, 2};
        System.out.println(solution.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        var cnt = new int[(int) 1e4 + 1];
        var max = 0;
        for (var num : nums) {
            cnt[num]++;
            max = Math.max(max, num);
        }

        var dp = new int[max + 1];
        dp[1] = cnt[1];
        for (int i = 2; i < max + 1; i++) {
            dp[i] = Math.max(cnt[i] * i + dp[i - 2], dp[i - 1]);
        }
        return dp[max];
    }
}