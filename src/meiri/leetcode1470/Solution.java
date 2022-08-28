 package meiri.leetcode1470;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        int l = 0, r = n;
        int idx = 0;
        while (l < n) {
            ans[idx++] = nums[l++];
            ans[idx++] = nums[r++];
        }
        return ans;
    }
}