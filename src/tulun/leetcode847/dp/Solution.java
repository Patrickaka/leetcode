package tulun.leetcode847.dp;

import java.util.Arrays;

class Solution {

    static int INF = 0x3f3f3f3f;

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                dist[i][j] = 1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[][] dp = new int[mask][n];
        for (int i = 0; i < mask; i++) {
            Arrays.fill(dp[i], INF);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        for (int state = 0; state < mask; state++) {
            for (int i = 0; i < n; i++) {
                if (((state >> i) & 1) == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (((state >> j) & 1) == 0) {
                        continue;
                    }
                    dp[state | (1 << j)][j] = Math.min(dp[state | (1 << j)][j], dp[state][i] + dist[i][j]);
                }
            }
        }
        return -1;
    }
}