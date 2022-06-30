package qujianqiuhe.qianzhuihe;

class Solution724 {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] lsum = new int[n + 10];
        int[] rsum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            lsum[i] = lsum[i - 1] + nums[i - 1];
        }
        for (int i = n; i > 0; i--) {
            rsum[i] = rsum[i + 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            if (lsum[i] == rsum[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(sums));
    }
}