package meiri.leetcode873;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.lenLongestFibSubseq(arr));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j > 0 && j + 2 > ans; j--) {
                if (arr[i] - arr[j] >= arr[j]) {
                    break;
                }
                int t = map.getOrDefault(arr[i] - arr[j], -1);
                if (t == -1) {
                    continue;
                }
                dp[i][j] = Math.max(3, dp[j][t] + 1);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}