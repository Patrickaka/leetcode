package tulun.leetcode1765;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[][] highestPeak(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    deque.add(i * m + j);
                    g[i][j] = 0;
                } else {
                    g[i][j] = -1;
                }
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            int x = poll / m, y = poll % m;
            for (int[] pos : positions) {
                int nx = x + pos[0], ny = y + pos[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (g[nx][ny] >= 0) {
                    continue;
                }
                deque.add(nx * m + ny);
                g[nx][ny] = g[x][y] + 1;
            }
        }
        return g;
    }

}