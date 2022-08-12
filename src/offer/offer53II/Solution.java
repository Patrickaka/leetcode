package offer.offer53II;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (r == n - 1 && r == nums[r]) {
            return r + 1;
        }
        return r;
    }
}