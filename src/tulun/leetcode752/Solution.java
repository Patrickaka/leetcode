package tulun.leetcode752;

import java.util.*;


class Solution {

    static String start = "0000";
    Set<String> set;

    public static void main(String[] args) {
        String[] deadends = {"1131", "1303", "3113", "0132", "1301", "1303", "2200", "0232", "0020", "2223"};
        String target = "3312";
        Solution solution = new Solution();
        System.out.println(solution.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains(start)) {
            return -1;
        }
        if (Objects.equals(target, start)) {
            return 0;
        }
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        d1.add(start);
        m1.put(start, 0);
        d2.add(target);
        m2.put(target, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int ans;
            if (d1.size() <= d2.size()) {
                ans = update(d1, m1, m2);
            } else {
                ans = update(d2, m2, m1);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    public int update(Deque<String> deque, Map<String, Integer> m1, Map<String, Integer> m2) {
        String s = deque.pollFirst();
        int step = m1.get(s);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                assert s != null;
                String ns = s.substring(0, i) + (Integer.parseInt(String.valueOf(s.charAt(i))) + 10 + (j == 0 ? 1 : -1)) % 10 + s.substring(i + 1);
                if (set.contains(ns) || m1.containsKey(ns)) {
                    continue;
                }
                if (m2.containsKey(ns)) {
                    System.out.println(ns);
                    System.out.println(step);
                    System.out.println(m2.get(ns));
                    return m2.get(ns) + step + 1;
                }
                deque.add(ns);
                m1.put(ns, step + 1);
            }
        }
        return -1;
    }
}