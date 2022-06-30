package qujianqiuhe.qianzhuihe;

class Solution1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
//        int n = arr.length;
//        int[] s = new int[n + 10];
//        int ans = 0;
//        s[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            s[i] = s[i - 1] + arr[i - 1];
//        }
//        for (int i = 1; i <= n; i += 2) {
//            for (int j = 0; j < n - i + 1; j++) {
//                ans += s[j + i] - s[j];
//            }
//        }
//        return ans;
        int n = arr.length, ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i - 1] + sum[i - 1];
        }
        for (int i = 1; i <= n; i += 2) {
            for (int j = 0; j < n - i + 1; j++) {
                ans += sum[j + i] - sum[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        int ans = sumOddLengthSubarrays(arr);
        System.out.println(ans);
    }
}