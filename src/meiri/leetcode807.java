package meiri;

class Solution807 {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int ans = 0;
        int[] line1 = new int[length];
        int[] line2 = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                line1[i] = Math.max(grid[i][j], line1[i]);
                line2[j] = Math.max(grid[i][j], line2[j]);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                ans += Math.min(line1[i], line2[j]) - grid[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int ans = maxIncreaseKeepingSkyline(grid);
        System.out.println(ans);
    }
}