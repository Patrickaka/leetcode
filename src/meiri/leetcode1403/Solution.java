package meiri.leetcode1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int rsum = 0, lsum = 0;
        for (int num : nums) {
            rsum += num;
        }
        for (int i = n - 1; i >= 0; i--) {
            result.add(nums[i]);
            lsum += nums[i];
            rsum -= nums[i];
            if (lsum > rsum) {
                return result;
            }
        }
        return result;
    }
}