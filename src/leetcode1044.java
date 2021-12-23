import java.util.HashMap;
import java.util.Map;


class Solution {

    int N = 30006, M = 1313131;
    long[] h = new long[N], p = new long[N];

    public String longestDupSubstring(String s) {

        int n = s.length();
        String ans = "";
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            h[i + 1] = h[i] * M + s.charAt(i);
            p[i + 1] = p[i] * M;
        }
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            String temp = check(s, mid);
            if (temp.length() != 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
            ans = temp.length() > ans.length() ? temp : ans;
        }
        return ans;
    }

    public String check(String s, int length) {
        int n = s.length();
//        Set<Long> set = new HashSet<>();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 1; i + length - 1 <= n; i++) {
            int j = i + length - 1;
            long hash = h[j] - h[i - 1] * p[length];
//            if (set.contains(hash)) {
//                return s.substring(i - 1, j);
//            }
//            set.add(hash);
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) {
                return s.substring(i - 1, j);
            }
            map.put(hash, cnt + 1);
        }
        return "";
    }
}