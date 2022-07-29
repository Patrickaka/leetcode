package tulun.leetcode778;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    int n;
    int[] p;

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    boolean query(int a, int b) {
        return find(a) == find(b);
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    int getIdx(int x, int y) {
        return x * n + y;
    }

    public int swimInWater(int[][] grid) {
        n = grid.length;
        p = new int[n * n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = getIdx(i, j);
                p[idx] = idx;
                if (i + 1 < n) {
                    int b = getIdx(i + 1, j);
                    int w = Math.max(grid[i][j], grid[i + 1][j]);
                    edges.add(new int[]{idx, b, w});
                }
                if (j + 1 < n) {
                    int b = getIdx(i, j + 1);
                    int w = Math.max(grid[i][j], grid[i][j + 1]);
                    edges.add(new int[]{idx, b, w});
                }
            }
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        int start = getIdx(0, 0), end = getIdx(n - 1, n - 1);
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if (query(start, end)) {
                return w;
            }
        }
        return 0;
    }
}