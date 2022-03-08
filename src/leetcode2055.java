import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution2055 {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] temp = new int[s.length()];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(ans, 0);
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            temp[i] = num;
            if (chars[i] == '*') {
                num++;
            } else {
                list.add(i);
            }
        }
        Collections.sort(list);
        if (list.size() <= 2) {
            return ans;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a = query[0], b = query[1];
            int c = -1, d = -1;
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= a) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (list.get(r) >= a) {
                c = list.get(r);
            } else {
                continue;
            }
            l = 0;
            r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= b) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (list.get(r) <= b) {
                d = list.get(r);
            } else {
                continue;
            }
            if (c <= d) {
                ans[i] = temp[c] - temp[d];
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