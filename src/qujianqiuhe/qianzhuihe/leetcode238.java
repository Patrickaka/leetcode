package qujianqiuhe.qianzhuihe;

class Solution238 {
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] s1 = new int[n + 10], s2 = new int[n + 10];
//        s1[0] = s2[n + 1] = 1;
//        for (int i = 1; i <= n; i++) {
//            s1[i] = s1[i - 1] * nums[i - 1];
//        }
//        for (int i = n; i >= 1; i--) {
//            s2[i] = s2[i + 1] * nums[i - 1];
//        }
//        int[] ans = new int[n];
//        for (int i = 1; i <= n; i++) {
//            ans[i - 1] = s1[i - 1] * s2[i + 1];
//        }
//        return ans;
//    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = 1; i < n; i++) {
            ans[i] = j;
            j *= nums[i];
        }
        for (int i = n - 1, j = 1; i >= 0; i--) {
            ans[i] *= j;
            j *= nums[i];
        }
        return ans;
    }
}