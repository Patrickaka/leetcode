package tulun.leetcode1036;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static long BASE = 131L;
    static int N = (int) 1e6, MAX_SIZE = (int) 1e5;
    int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Set<Long> set = new HashSet<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] blocked = {{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        System.out.println(solution.isEscapePossible(blocked, source, target));
    }

    long getPosition(long x, long y) {
        return x * BASE + y;
    }

    long getPosition(int[] arr) {
        return arr[0] * BASE + arr[1];
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] block : blocked) {
            set.add(getPosition(block));
        }
        int n = blocked.length;
        MAX_SIZE = n * (n - 1) / 2;
        if (getPosition(source) == getPosition(target) || set.isEmpty()) {
            return true;
        }
        return bfs(source, target) && bfs(target, source);
    }

    boolean bfs(int[] source, int[] target) {
        Set<Long> vis = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(source);
        vis.add(getPosition(source));
        while (!deque.isEmpty() && vis.size() <= MAX_SIZE) {
            int[] poll = deque.poll();
            int x = poll[0], y = poll[1];
            if (getPosition(x, y) == getPosition(target)) {
                return true;
            }
            if (x == target[0] && y == target[1]) {
                return true;
            }
            for (int[] pos : positions) {
                int nx = x + pos[0], ny = y + pos[1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (!set.contains(getPosition(nx, ny)) && !vis.contains(getPosition(nx, ny))) {
                    vis.add(getPosition(nx, ny));
                    deque.addLast(new int[]{nx, ny});
                }
            }
        }
        return vis.size() > MAX_SIZE;
    }
}