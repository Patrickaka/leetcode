package tulun.lcp07.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    Map<Integer, Set<Integer>> map;
    int ans = 0, k = 0, n = 0;

    public int numWays(int _n, int[][] relation, int _k) {
        map = new HashMap<>();
        k = _k;
        n = _n;
        for (int[] r : relation) {
            Set<Integer> set = map.getOrDefault(r[0], new HashSet<>());
            set.add(r[1]);
            map.put(r[0], set);
        }
        dfs(0, 0);
        return ans;
    }

    void dfs(int val, int num) {
        if (num == k) {
            if (val == n - 1) {
                ans++;
            }
            return;
        }
        Set<Integer> set = map.get(val);
        if (set == null) {
            return;
        }
        for (int i : set) {
            dfs(i, num + 1);
        }
    }
}