package tulun.leetcode952;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static int N = 20010;
    int[] p = new int[N], sz = new int[N];
    int ans = 1;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4, 6, 15, 35};
        System.out.println(s.largestComponentSize(nums));
    }

    void union(int a, int b) {
        if (p[find(a)] == p[find(b)]) {
            return;
        }
        sz[find(a)] += sz[find(b)];
        p[find(b)] = p[find(a)];
        ans = Math.max(ans, sz[find(a)]);
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    void add(Map<Integer, List<Integer>> map, int key, int val) {
        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        list.add(val);
        map.put(key, list);
    }

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            p[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = 2; j * j <= cur; j++) {
                if (cur % j == 0) {
                    add(map, j, i);
                }
                while (cur % j == 0) {
                    cur /= j;
                }
            }
            if (cur > 1) {
                add(map, cur, i);
            }
        }
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 1; i < list.size(); i++) {
                union(list.get(0), list.get(i));
            }
        }
        return ans;
    }
}