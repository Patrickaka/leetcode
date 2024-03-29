package offer.offerII09;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        var n = nums.length;
        var ans = 0;
        if (k <= 1) {
            return 0;
        }
        for (int i = 0, j = 0, cur = 1; i < n; i++) {
            cur *= nums[i];
            while (cur >= k) {
                cur /= nums[j++];
            }
            ans += (i - j + 1);
        }
        return ans;
    }
}