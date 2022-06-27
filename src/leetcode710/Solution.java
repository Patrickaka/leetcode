package leetcode710;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {

    List<int[]> arr = new ArrayList<>();
    int[] sum = new int[100010];
    int count;
    Random random = new Random();

    public Solution(int n, int[] blacklist) {
        Arrays.sort(blacklist);
        int m = blacklist.length;
        if (m == 0) {
            arr.add(new int[]{0, n - 1});
        } else {
            if (blacklist[0] != 0) {
                arr.add(new int[]{0, blacklist[0] - 1});
            }
            for (int i = 0; i < m - 1; i++) {
                arr.add(new int[]{blacklist[i] + 1, blacklist[i + 1] - 1});
            }
            if (blacklist[m - 1] != n - 1) {
                arr.add(new int[]{blacklist[m - 1] + 1, n - 1});
            }
        }

        count = arr.size();
        for (int i = 1; i <= count; i++) {
            int[] info = arr.get(i - 1);
            sum[i] = sum[i - 1] + info[1] - info[0] + 1;
        }
    }

    public int pick() {
        int val = random.nextInt(sum[count]) + 1;
        int l = 1, r = count;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int[] info = arr.get(r - 1);
        int a = info[0], b = info[1], end = sum[r];
        return b - (end - val);
    }
}

