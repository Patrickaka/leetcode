package dp.leetcode152;

class Solution {
    public int maxProduct(int[] nums) {
        var max = nums[0];
        var maxPrev = 1;
        var minPrev = 1;
        for (var num : nums) {
            var cntMax = Math.max(Math.max(num, num * minPrev), num * maxPrev);
            var cntMin = Math.min(Math.max(num, num * minPrev), num * maxPrev);
            maxPrev = cntMax;
            minPrev = cntMin;
            max = Math.max(cntMax, max);
        }
        return max;
    }
}