package review.zhousai.leetcode6132;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};
        Solution s = new Solution();
        System.out.println(s.minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        while (true) {
            int cnt = 0;
            int min = 101;
            for (int i : nums) {
                if (i < min && i > 0) {
                    min = i;
                }
                if (i == 0) {
                    cnt++;
                }
            }
            if (cnt == n) {
                return ans;
            }
            cnt = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = nums[i] - min >= 0 ? nums[i] - min : nums[i];
                if (nums[i] == 0) {
                    cnt++;
                }
            }
            ans++;
            if (cnt == n) {
                break;
            }
        }
        return ans;
    }
}