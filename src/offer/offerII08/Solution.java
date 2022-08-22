package offer.offerII08;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 10;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int t = sums[i];
            int k = t - target;
            int l = 1, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sums[mid] <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (sums[r] <= k) {
                ans = Math.max(ans, i - r);
            }
        }
        return ans;
    }
}