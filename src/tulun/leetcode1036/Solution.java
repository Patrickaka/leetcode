package tulun.leetcode1036;

import java.util.*;

class Solution {

    static int MAX_EDGE = (int) 1e6, MAX_SIZE = (int) 1e5;
    int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Set<String> set = new HashSet<>();

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] block : blocked) {
            set.add(Arrays.toString(block));
        }
        int n = blocked.length;
        MAX_SIZE = n * (n - 1) / 2;
        return check(source, target) && check(target, source);
    }

    private boolean check(int[] source, int[] target) {
        Deque<int[]> deque = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        deque.add(source);
        vis.add(Arrays.toString(source));
        while (!deque.isEmpty() && vis.size() <= MAX_SIZE) {
            int[] poll = deque.pollFirst();
            if (poll[0] == target[0] && poll[1] == target[1]) {
                return true;
            }
            for (int[] position : positions) {
                int x = poll[0] + position[0], y = poll[1] + position[1];
                int[] cur = new int[]{x, y};
                if (x < 0 || y < 0 || x >= MAX_EDGE || y >= MAX_EDGE) {
                    continue;
                }
                if (set.contains(Arrays.toString(cur))) {
                    continue;
                }
                if (vis.contains(Arrays.toString(cur))) {
                    continue;
                }
                vis.add(Arrays.toString(cur));
                deque.addLast(cur);
            }
        }
        return vis.size() > MAX_SIZE;
    }
}
