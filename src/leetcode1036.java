import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution1036 {

    int edge = (int) 1e6, max;
    long base = 131L;
    Set<Long> set = new HashSet<>();
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] block : blocked) {
            set.add(block[0] * base + block[1]);
        }
        int n = blocked.length;
        max = n * (n - 1) / 2;
        return check(source, target) && check(target, source);
    }

    private boolean check(int[] source, int[] target) {
        Set<Long> vis = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(source);
        vis.add(source[0] * base + source[1]);
        while (!deque.isEmpty() && vis.size() <= max) {
            int[] temp = deque.pollFirst();
            int x = temp[0], y = temp[1];
            if (x == target[0] && y == target[1]) {
                return true;
            }
            for (int[] position : move) {
                int nx = x + position[0], ny = y + position[1];
                if (nx < 0 || nx >= edge || ny < 0 || ny >= edge) {
                    continue;
                }
                long hash = nx * base + ny;
                if (set.contains(hash)) {
                    continue;
                }
                if (vis.contains(hash)) {
                    continue;
                }
                deque.addLast(new int[]{nx, ny});
                vis.add(hash);
            }
        }
        return vis.size() > max;
    }
}