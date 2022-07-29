package tulun.leetcode778;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    static int n = 50;
    static int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int cnt = 0, target = 0;
    boolean[] vis = new boolean[n * n];

    int getPosition(int x, int y) {
        return x * n + y;
    }

    public int swimInWater(int[][] grid) {
        int len = grid.length;
        target = getPosition(len - 1, len - 1);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        deque.add(0);
        map.put(0, 0);
        vis[0] = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                int poll = deque.poll();
                if (poll == target) {
                    return map.get(poll);
                }
                int x = poll / n, y = poll % n;
                for (int[] pos : positions) {
                    int nx = x + pos[0], ny = y + pos[1];
                    int np = getPosition(nx, ny);
                    int step = map.get(poll);
                    if (nx < 0 || ny < 0 || nx >= len || ny >= len) {
                        continue;
                    }
                    if (!vis[np] && grid[nx][ny] <= cnt) {
                        deque.add(np);
                        map.put(np, step + 1)
                    }
                    if (!vis[np] && grid[nx][ny] > cnt) {
                        deque.add(poll);
                    }
                }
            }

        }
    }
}