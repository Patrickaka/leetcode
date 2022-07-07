package qujianqiuhe.shuzhuangshuzu.leetcode327;

import java.util.*;

class Solution {

    int m;
    int n = 3 * 100010;
    int[] tr = new int[n];

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int v) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tr[i];
        }
        return ans;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long> set = new HashSet<>();
        long s = 0;
        set.add(s);
        for (int i : nums) {
            s += i;
            set.add(s);
            set.add(s - lower);
            set.add(s - upper);
        }
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Long, Integer> map = new HashMap<>();
        for (long x : list) {
            map.put(x, ++m);
        }
        s = 0;
        int ans = 0;
        add(map.get(s), 1);
        for (int i : nums) {
            s += i;
            int a = map.get(s - lower), b = map.get(s - upper) - 1;
            ans += query(a) - query(b);
            add(map.get(s), 1);
        }
        return ans;
    }
}