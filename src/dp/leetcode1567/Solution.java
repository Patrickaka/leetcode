package dp.leetcode1567;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxLen(new int[]{0, 1, -2, -3, -4}));
    }

    /**
     * dp
     * 分别计算以i结尾的子数组的最长正数长度和负数长度
     *
     * @param nums 给定一个整数数组
     * @return 乘积为正数的最长子数组长度
     */
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n], negative = new int[n];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int ans = positive[0];
        for (int i = 1; i < n; i++) {
            int t = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = t;
            } else if (nums[i] < 0) {
                positive[i] = t;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            ans = Math.max(ans, positive[i]);
        }
        return ans;
    }
}