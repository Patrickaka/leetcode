package meiri.leetcode135;

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans = n;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && candies[i] < candies[i - 1]) {
                ans += (candies[i - 1] - candies[i] + 1);
                candies[i] = candies[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1] && candies[i] >= candies[i - 1]) {
                ans += (candies[i] - candies[i - 1] + 1);
                candies[i - 1] = candies[i] + 1;
            }

        }
        return ans;
    }
}