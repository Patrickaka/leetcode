package tulun.leetcode847.Astar;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int INF = 0x3f3f3f3f;
    int n;

    int f(int state) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int shortestPathLength(int[][] g) {
        n = g.length;
        int mask = 1 << n;
        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            q.add(new int[]{1 << i, i, f(1 << i)});
        }
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int state = poll[0], u = poll[1], step = dist[state][u];
            if (state == mask - 1) {
                return step;
            }
            for (int i : g[u]) {
                int nState = state | (1 << i);
                if (dist[nState][i] > step + 1) {
                    dist[nState][i] = step + 1;
                    q.add(new int[]{nState, i, step + 1 + f(nState)});
                }
            }
        }
        return -1;
    }
}
