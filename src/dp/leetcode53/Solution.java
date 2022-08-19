package dp.leetcode53;

class Solution {
    public int maxSubArray(int[] nums) {
        var n = nums.length;
        var max = nums[0];
        var prev = nums[0];
        for (var i = 1; i < n; i++) {
            var cnt = Math.max(nums[i], nums[i] + prev);
            prev = cnt;
            max = Math.max(max, cnt);
        }
        return max;
    }
}