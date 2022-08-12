package meiri.leetcode34;

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int start = -1, end = -1;
        for (int i = r; i >= 0; i--) {
            if (nums[i] < target) {
                if (end != -1) {
                    start = i + 1;
                }
                break;
            }
            if (nums[i] == target) {
                if (end == -1) {
                    end = i;
                }
                if (i == 0) {
                    start = i;
                }
            }
        }
        return new int[]{start, end};
    }
}
