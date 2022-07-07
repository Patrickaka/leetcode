package tulun.leetcode1162;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(s.maxDistance(grid));
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length, ans = -1;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    d.add(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] position : positions) {
                int nx = position[0] + dx, ny = position[1] + dy;
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] != 0) {
                    continue;
                }
                grid[nx][ny] = step + 1;
                d.addLast(new int[]{nx, ny});
                map.put(nx * n + ny, step + 1);
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }
}
