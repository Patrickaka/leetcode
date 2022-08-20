package qujianqiuhe.chafen.leetcode798;

class Solution {
    /**
     * 假设当前数字为第i个数字，轮调次数为k
     * 则当前下标为i - k
     * 由于0 <= i - k <= n - 1 => i - (n - 1) <= k <= i
     * 并且若想得分 需要 i - k >= nums[i] => i - nums[i] >= k
     * 所以 i - (n - 1) <= k <= i - nums[i]
     *
     * @param nums nums
     * @return int
     */
    public int bestRotation(int[] nums) {
        var n = nums.length;
        var diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            var a = (i - (n - 1) + n) % n;
            var b = (i - nums[i] + n) % n;
            if (a < b) {
                diff[a]++;
                diff[b]--;
            } else {
                diff[a]++;
                diff[n]--;
                diff[0]++;
                diff[b + 1]--;
            }
        }
        var max = 0;
        var sum = 0;
        var ans = 0;
        for (var i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum > max) {
                ans = i;
                max = sum;
            }
        }
        return ans;
    }
}