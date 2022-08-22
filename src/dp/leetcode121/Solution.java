package dp.leetcode121;

class Solution {

    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;
        for (int price : prices) {
            if (price - min > max) {
                max = price - min;
            }
            if (price < min) {
                min = price;
            }
        }
        return max;
    }
}