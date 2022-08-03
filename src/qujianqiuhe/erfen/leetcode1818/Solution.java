package qujianqiuhe.erfen.leetcode1818;

import java.util.Arrays;

class Solution {
    int mod = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] cp1 = nums1.clone();
        Arrays.sort(cp1);
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            int target = nums2[i];
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (cp1[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int oldSum = Math.abs(nums1[i] - target);
            int newSum = Math.abs(cp1[r] - target);
            if (r + 1 < n) {
                newSum = Math.min(newSum, Math.abs(cp1[r + 1] - target));
            }
            sum += oldSum;
            if (oldSum - newSum > max) {
                max = oldSum - newSum;
            }
        }
        return (int) ((sum - max) % mod);
    }
}