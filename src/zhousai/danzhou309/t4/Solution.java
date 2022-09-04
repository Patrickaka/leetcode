package zhousai.danzhou309.t4;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int max = 0, ans = 0;
        int[] vis = new int[n];
        long[] book = new long[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int a = 0, b = 0;
        for (int[] meet : meetings) {
            long min = Integer.MAX_VALUE;
            int idx = 0;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (book[j] < min) {
                    min = book[j];
                    idx = j;
                }
                if (book[j] <= meet[0]) {
                    a++;
                    flag = true;
                    book[j] = meet[1];
                    vis[j]++;
                    break;
                }
            }
            if (!flag) {
                b++;
                book[idx] += meet[1] - meet[0];
                vis[idx]++;
            }
        }
        System.out.println(Arrays.toString(book));
        System.out.println(Arrays.toString(vis));
        System.out.println(a + "  " + b);
        for (int i = 0; i < n; i++) {
            if (vis[i] > max) {
                max = vis[i];
                ans = i;
            }
        }
        return ans;
    }
}