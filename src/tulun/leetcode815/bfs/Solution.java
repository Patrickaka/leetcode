package tulun.leetcode815.bfs;

import java.util.*;

class Solution {


    boolean[] vis = new boolean[(int) 1e6 + 10];

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(solution.numBusesToDestination(routes, 1, 6));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Set<Integer>> m2 = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                if (station == source) {
                    deque.addLast(i);
                    m1.put(i, 1);
                }
                Set<Integer> set = m2.getOrDefault(station, new HashSet<>());
                set.add(i);
                m2.put(station, set);
            }
        }

        while (!deque.isEmpty()) {
            int poll = deque.poll();
            int step = m1.get(poll);

            for (int station : routes[poll]) {
                if (station == target) {
                    return step;
                }
                Set<Integer> set = m2.get(station);
                if (set == null) {
                    continue;
                }
                for (int nr : set) {
                    if (!m1.containsKey(nr)) {
                        m1.put(nr, step + 1);
                        deque.add(nr);
                    }
                }
            }
        }
        return -1;

    }
}