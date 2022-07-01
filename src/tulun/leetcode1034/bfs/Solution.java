package tulun.leetcode1034.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length, m = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] ans = new int[n][m];
        int[][] positions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        deque.addLast(new int[]{row, col});
        while (!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int count = 0;
            for (int[] position : positions) {
                int x = position[0], y = position[1];
                int dx = temp[0] + x, dy = temp[1] + y;
                if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }
                if (grid[dx][dy] != grid[temp[0]][temp[1]]) {
                    continue;
                }
                count++;
                if (ans[dx][dy] != 0) {
                    continue;
                }
                deque.addLast(new int[]{dx, dy});
            }
            if (count == 4) {
                ans[temp[0]][temp[1]] = grid[temp[0]][temp[1]];
            } else {
                ans[temp[0]][temp[1]] = color;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }
}
