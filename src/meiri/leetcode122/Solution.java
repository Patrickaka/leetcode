package meiri.leetcode122;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0, min = prices[0], max = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1]) {
                min = Math.min(prices[i - 1], min);
                if (i == n - 1) {
                    ans += (prices[i] - min);
                }
            }
            if (prices[i] < prices[i - 1]) {
                ans += (prices[i - 1] - min);
                min = prices[i];
            }
        }
        return ans;
    }
}