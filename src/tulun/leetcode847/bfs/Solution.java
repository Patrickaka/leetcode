package tulun.leetcode847.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    static int INF = 0x3f3f3f3f;

    public int shortestPathLength(int[][] graph) {
        //状态压缩
        int n = graph.length;
        int mask = 1 << n;

        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; i++) {
            Arrays.fill(dist[i], INF);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            deque.add(new int[]{1 << i, i});
        }
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int state = poll[0], u = poll[1], step = dist[state][u];
            if (state == mask - 1) {
                return step;
            }
            for (int i : graph[u]) {
                if (dist[state | 1 << i][i] == INF) {
                    dist[state | 1 << i][i] = step + 1;
                    deque.addLast(new int[]{state | 1 << i, i});
                }
            }
        }
        return -1;
    }
}