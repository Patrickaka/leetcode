package tulun.leetcode1765;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0, 1}, {0, 0}};
        System.out.println(Arrays.deepToString(s.highestPeak(grid)));
    }

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] ans = new int[n][m];
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    deque.add(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] position : positions) {
                int nx = position[0] + dx, ny = position[1] + dy;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map.containsKey(nx * n + ny)) {
                    continue;
                }
                deque.addLast(new int[]{nx, ny});
                map.put(nx * n + ny, step + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isWater[i][j] = map.get(i * n + j);
            }
        }
        return isWater;
    }
}