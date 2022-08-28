package zhousai.leetcode6160;

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m = nums.length, n = queries.length;
        int[] ans = new int[n];
        int[] sums = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            for (int j = 1; j <= m; j++) {
                if (sums[j] > queries[i]) {
                    ok = true;
                    ans[i] = j - 1;
                    break;
                }
            }
            if (!ok) {
                ans[i] = m;
            }
        }
        return ans;
    }
}