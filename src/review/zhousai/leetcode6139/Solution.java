package review.zhousai.leetcode6139;

import java.util.*;

class Solution {

    int idx = 0;
    int n = (int) 1e5, m = n * 2;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> rest = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Arrays.fill(he, -1);
        for (int i : restricted) {
            rest.add(i);
        }
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        visited.add(0);
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (!rest.contains(j) && !visited.contains(j)) {
                    deque.add(j);
                    visited.add(j);
                }
            }
        }
        System.out.println(Arrays.toString(visited.toArray()));
        return visited.size();
    }

    int[] he = new int[n], ne = new int[m], e = new int[m];


}