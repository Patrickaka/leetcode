package tulun.leetcode1020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {

    int[][] grid;
    int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int S, N = 500 * 500 + 10;
    int m, n;
    int[] h1 = new int[N];

    void add(int x) {
        h1[x] = h1[S];
    }

    int find(int x) {
        if (h1[x] != x) {
            h1[x] = h1[h1[x]];
        }
        return h1[x];
    }

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        S = m * n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= S; i++) {
            h1[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    int idx = i * n + j;
                    if (grid[i][j] == 1 && find(idx) == idx) {
                        dfs(i, j);
                    }
                }
                if (grid[i][j] == 1) {
                    set.add(i * n + j);
                }
            }
        }
        for (int v : set) {
            if (find(v) != find(S)) {
                ans++;
            }
        }
        return ans;
    }

    void dfs(int x, int y) {
        add(x * n + y);
        for (int[] pos : positions) {
            int nx = x + pos[0], ny = y + pos[1];
            int idx = nx * n + ny;
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 1 && find(idx) == idx) {
                dfs(nx, ny);
            }
        }
    }
}