package tulun.leetcode994;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0, 0, 1, 2}, {2, 0, 1, 1}};
        System.out.println(s.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0, total = 0;
        int hash = 20;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    d.add(new int[]{i, j});
                    map.put(i * hash + j, 0);
                }
                if (grid[i][j] == 1) {
                    total++;
                }
            }
        }
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * hash + dy);
            for (int[] position : positions) {
                int nx = position[0] + dx, ny = position[1] + dy;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (grid[nx][ny] == 0 || grid[nx][ny] == 2) {
                    continue;
                }
                if (map.containsKey(nx * hash + ny)) {
                    continue;
                }
                d.addLast(new int[]{nx, ny});
                System.out.println(Arrays.toString(new int[]{nx, ny}));
                total--;
                map.put(nx * hash + ny, step + 1);
                ans = Math.max(ans, step + 1);
            }
        }
        return total == 0 ? ans : -1;
    }

}
