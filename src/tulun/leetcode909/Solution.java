package tulun.leetcode909;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}
                , {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}});
        System.out.println(ans);
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] array = new int[n * n + 1];
        for (int i = n - 1, flag = 1, idx = 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (flag == 1) {
                    array[idx++] = board[i][j];
                }
                if (flag == -1) {
                    array[idx++] = board[i][n - 1 - j];
                }
            }
            flag *= -1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        deque.addLast(1);
        map.put(1, 0);
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            int step = map.get(cur);
            if (cur == n * n) {
                return step;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > n * n) {
                    continue;
                }
                if (array[next] != -1) {
                    next = array[next];
                }
                if (map.containsKey(next)) {
                    continue;
                }
                map.put(next, step + 1);
                deque.addLast(next);
            }
        }
        return -1;
    }
}