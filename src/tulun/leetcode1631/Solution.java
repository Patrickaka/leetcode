package tulun.leetcode1631;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int[] p;
    int m, n;

    public static void main(String[] args) {
        int[][] heights = {{1, 10, 6, 7, 9, 10, 4, 9}};
        Solution s = new Solution();
        System.out.println(s.minimumEffortPath(heights));
    }

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    boolean query(int a, int b) {
        return p[find(a)] == p[find(b)];
    }

    int getIdx(int x, int y) {
        return x * n + y;
    }

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        p = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            p[i] = i;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    q.add(new int[]{getIdx(i, j), getIdx(i + 1, j), Math.abs(heights[i][j] - heights[i + 1][j])});
                }
                if (j + 1 < n) {
                    q.add(new int[]{getIdx(i, j), getIdx(i, j + 1), Math.abs(heights[i][j] - heights[i][j + 1])});
                }
            }
        }
        int start = getIdx(0, 0), end = getIdx(m - 1, n - 1);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            union(cur[0], cur[1]);
            if (query(start, end)) {
                return cur[2];
            }
        }
        return 0;
    }
}