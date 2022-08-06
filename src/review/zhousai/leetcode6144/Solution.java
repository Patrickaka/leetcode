package review.zhousai.leetcode6144;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumReplacement(new int[]{7, 6}));
    }

    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int max = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans += (nums[i] - 1) / max;
            max = nums[i] / ((nums[i] + max - 1) / max);
        }
        return ans;
    }
}