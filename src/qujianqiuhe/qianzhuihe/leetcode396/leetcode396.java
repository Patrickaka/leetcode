package qujianqiuhe.qianzhuihe.leetcode396;

public class leetcode396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n * 2 + 10];
        for (int i = 1; i <= n * 2; i++) {
            sum[i] = sum[i - 1] + nums[(i - 1) % n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += nums[i - 1] * (i - 1);
        }
//        for (int i = n + 1, cur = ans; i < n * 2; i++) {
//            cur += nums[(i - 1) % n] * (n - 1);
//            cur -= sum[i - 1] - sum[i - n];
//            if (cur > ans) {
//                ans = cur;
//            }
//        }
        for (int i = 1, cur = ans; i < n; i++) {
            cur += nums[(i + n - 1) % n] * (n - 1);
            cur -= sum[i + n - 1] - sum[i];
            if (cur > ans) {
                ans = cur;
            }
        }
        return ans;
    }
}
