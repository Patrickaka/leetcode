package moni.leetcode1260;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int tot = m * n;
        k = k % tot;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                l.add(list.get((idx - k + tot) % tot));
            }
            ans.add(l);
        }
        return ans;
    }
}