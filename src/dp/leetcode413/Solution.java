package dp.leetcode413;

/**
 * 等差数列划分
 */
class Solution {

    /**
     * 若以i结尾的等差子数组数量是t，则对于i+1。若nums[i + 1] - nums[i] == nums[i] - nums[i - 1]
     * 那么以i+1结尾的等差子数组数量为t + {nums[i - 1, nums[i], nums[i + 1]} 即t + 1
     *
     * @param nums 给定数组
     * @return 数组中为等差数列的数组的数目
     */
    public int numberOfArithmeticSlices(int[] nums) {
        var n = nums.length;
        var ans = 0;
        if (n < 3) {
            return 0;
        }
        int d = nums[1] - nums[0], t = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == d) {
                t = t + 1;
            } else {
                d = nums[i] - nums[i - 1];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}