package tulun.lcp07.bfs;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        Solution s = new Solution();
        System.out.println(s.numWays(n, relation, k));
    }

    public int numWays(int n, int[][] relation, int k) {
        int ans = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : relation) {
            Set<Integer> set = map.getOrDefault(r[0], new HashSet<>());
            set.add(r[1]);
            map.put(r[0], set);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while (!deque.isEmpty() && k-- > 0) {
            int size = deque.size();
            while (size-- > 0) {
                Integer poll = deque.pollFirst();
                Set<Integer> set = map.get(poll);
                if (set == null) {
                    continue;
                }
                for (int i : set) {
                    deque.addLast(i);
                }
            }
        }
        while (!deque.isEmpty()) {
            if (deque.pollFirst() == n - 1) {
                ans++;
            }
        }
        return ans;
    }
}