package zhousai.danzhou306.t1;

import java.util.Arrays;

class Solution {

    int[][] grid;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        System.out.println(Arrays.deepToString(solution.largestLocal(grid)));
    }

    public int[][] largestLocal(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = getNum(i + 1, j + 1);
            }
        }
        return ans;
    }

    private int getNum(int x, int y) {
        int max = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}