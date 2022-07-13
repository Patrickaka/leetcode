package moni.leetcode1252;

import java.util.Arrays;

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] nums = new int[m][n];
        Arrays.fill(nums, 0);
        for (int[] ind : indices) {
            for (int i = 0; i < n; i++) {
                nums[ind[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                nums[i][ind[1]]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}