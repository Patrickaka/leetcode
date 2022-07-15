package tulun.leetcode417.bingchaji;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int N = 200 * 200 + 10;
    int[] p1 = new int[N], p2 = new int[N];
    int[][] positions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int n, m, tot, S, T;
    int[][] heights;

    public static void main(String[] args) {
        int[][] height = {{3, 3, 3, 3, 3, 3}, {3, 0, 3, 3, 0, 3}, {3, 3, 3, 3, 3, 3}};
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(height));
    }

    void union(int[] p, int a, int b) {
        p[find(p, a)] = p[find(p, b)];
    }

    boolean query(int[] p, int a, int b) {
        return find(p, a) == find(p, b);
    }

    int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        tot = m * n;
        S = tot + 1;
        T = tot + 2;
        for (int i = 0; i <= T; i++) {
            p1[i] = p2[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (i == 0 || j == 0) {
                    if (!query(p1, S, idx)) {
                        dfs(p1, S, i, j);
                    }
                }
                if (i == m - 1 || j == n - 1) {
                    if (!query(p2, T, idx)) {
                        dfs(p2, T, i, j);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (query(p1, S, idx) && query(p2, T, idx)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    void dfs(int[] p, int idx, int x, int y) {
        union(p, idx, x * n + y);
        for (int[] pos : positions) {
            int nx = x + pos[0], ny = y + pos[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (query(p, idx, nx * n + ny) || heights[x][y] > heights[nx][ny]) {
                continue;
            }
            dfs(p, idx, nx, ny);
        }
    }
}