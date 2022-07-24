package review.zhousai.leetcode6127;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.countExcellentPairs(nums, k));

    }

    public long countExcellentPairs(int[] nums, int k) {
        int[] c = new int[150];
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            String s = Integer.toBinaryString(num);
            int cnt = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    cnt++;
                }
            }
            c[cnt]++;
        }
        for (int i = 0; i < 70; i++) {
            for (int j = 0; j < 70; j++) {
                if (i + j >= k) {
                    ans += (long) c[i] * c[j];
                }
            }
        }
        return ans;
    }
}