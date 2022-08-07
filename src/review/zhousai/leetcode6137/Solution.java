package review.zhousai.leetcode6137;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPartition(new int[]{1, 1, 1, 2}));
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            boolean a = f[i - 1] && nums[i] == nums[i - 1];
            boolean b = i > 1 && f[i - 2] && (
                    nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                            nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2);
            if (a || b) {
                f[i + 1] = true;
            }
        }
        return f[n];
    }
}