package tulun.leetcode1239;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {

    static Map<Integer, Integer> map = new HashMap<>();

    int n;
    int ans = Integer.MIN_VALUE;
    int[] hash;

    int get(int cur) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        int ans = 0;
        for (int i = cur; i > 0; i -= lowbit(i)) {
            ans++;
        }
        map.put(cur, ans);
        return ans;
    }

    int lowbit(int i) {
        return i & -i;
    }

    void dfs(int u, int cur, int total) {
        if (get(cur | total) <= ans) {
            return;
        }
        if (u == n) {
            ans = Math.max(ans, get(cur));
            return;
        }
        if ((hash[u] & cur) == 0) {
            dfs(u + 1, hash[u] | cur, total - (total & hash[u]));
        }
        dfs(u + 1, cur, total);
    }

    public int maxLength(List<String> arr) {
        n = arr.size();
        HashSet<Integer> set = new HashSet<>();
        for (String s : arr) {
            int val = 0;
            for (char c : s.toCharArray()) {
                int t = c - 'a';
                if (((val >> t) & 1) != 0) {
                    val = -1;
                    break;
                }
                val |= (1 << t);
            }
            if (val != -1) {
                set.add(val);
            }
        }

        n = set.size();
        if (n == 0) {
            return 0;
        }
        hash = new int[n];

        int idx = 0;
        int total = 0;
        for (Integer i : set) {
            hash[idx++] = i;
            total |= i;
        }
        dfs(0, 0, total);
        return ans;
    }
}