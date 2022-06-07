import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2055 {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = queries.length;
        int[] sum = new int[n + 1], ans = new int[m];
        List<Integer> flag = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
            if (cs[i] == '|') {
                flag.add(i);
            }
        }
        if (flag.size() == 0) {
            return ans;
        }
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1], c, d;
            int a = 0, b = flag.size() - 1;
            while (a < b) {
                int mid = (a + b) >> 1;
                if (flag.get(mid) >= l) {
                    b = mid;
                } else {
                    a = mid + 1;
                }
            }
            if (flag.get(b) >= l) {
                c = flag.get(b);
            } else {
                continue;
            }
            a = 0;
            b = flag.size() - 1;
            while (a < b) {
                int mid = (a + b + 1) >> 1;
                if (flag.get(mid) <= r) {
                    a = mid;
                } else {
                    b = mid - 1;
                }
            }
            if (flag.get(b) <= r) {
                d = flag.get(b);
            } else {
                continue;
            }
            if (c <= d) {
                ans[i] = sum[d + 1] - sum[c];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        int[] ans = platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(ans));
    }
}