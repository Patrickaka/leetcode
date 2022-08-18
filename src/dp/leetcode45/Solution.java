package dp.leetcode45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int jump(int[] nums) {
        var n = nums.length;
        var dp = new int[n];
        Arrays.fill(dp, (int) 1e5 + 1);
        List<Integer> list = new ArrayList<>();
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                list.add(i);
                dp[i] = 1;
            } else {
                int l = 0, r = list.size();
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (list.get(mid) <= i + nums[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                dp[i] = dp[list.get(r)] == (int) 1e5 + 1 ? 0 : 1 + dp[list.get(r)];
            }
        }
        return dp[0];
    }

}