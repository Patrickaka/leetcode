package qujianqiuhe.qianzhuihe;

import java.util.Arrays;

class Solution825 {
    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0, n = ages.length;
        for (int i = n - 1; i > 0; i--) {
            int min = (int) (ages[i] * 0.5 + 7);
            int temp = 0;
            for (int j = i - 1; j >= 0 && ages[j] > min; j--) {
                temp++;
            }
            ans += temp;
            while (i > 0 && ages[i - 1] == ages[i]) {
                ans += temp;
                i--;
            }
            if (i == 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ages = {16, 17, 18};
        int ans = numFriendRequests(ages);
        System.out.println(ans);
    }
}