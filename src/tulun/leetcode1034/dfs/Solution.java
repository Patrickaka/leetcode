package tulun.leetcode1034.dfs;

class Solution {

    int n, m, c;
    int[][] grid, ans;
    int[][] positions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int[][] colorBorder(int[][] _grid, int row, int col, int color) {
        grid = _grid;
        c = color;
        n = grid.length;
        m = grid[0].length;
        ans = new int[n][m];
        dfs(row, col);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col) {
        int count = 0;
        for (int[] position : positions) {
            int dx = row + position[0], dy = col + position[1];
            if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                continue;
            }
            if (grid[row][col] != grid[dx][dy]) {
                continue;
            }
            count++;
            if (ans[dx][dy] != 0) {
                continue;
            }
            ans[dx][dy] = -1;
            dfs(dx, dy);
        }
        ans[row][col] = count == 4 ? grid[row][col] : c;
    }
}
