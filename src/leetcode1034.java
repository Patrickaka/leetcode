import java.util.ArrayDeque;
import java.util.Deque;

class Solution1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] positions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row, col});
        while (!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int x = temp[0], y = temp[1], count = 0;
            for (int[] position : positions) {
                int dx = x + position[0], dy = y + position[1];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                    continue;
                }
                if (grid[x][y] != grid[dx][dy]) {
                    continue;
                } else {
                    count++;
                }
                if (ans[dx][dy] != 0) {
                    continue;
                }
                deque.addLast(new int[]{dx, dy});
            }
            ans[x][y] = count == 4 ? grid[x][y] : color;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }
}