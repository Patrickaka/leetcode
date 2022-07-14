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
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    deque.add(i * n + j);
                    map.put(i * n + j, 0);
                }
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            int x = poll / n, y = poll % n, step = map.get(poll);
            for (int[] position : positions) {
                int dx = position[0], dy = position[1];
                int nx = x + dx, ny = y + dy;
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] != 0) {
                    continue;
                }
                deque.addLast(nx * n + ny);
                map.put(nx * n + ny, step + 1);
                grid[nx][ny] = step + 1;
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }
}