package meiri;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
//        if (board[0][0] != -1) {
//            return -1;
//        }
        int[] nums = new int[n * n + 1];
        boolean flag = true;
        for (int i = n - 1, idx = 1; i >= 0; i--) {
            for (int j = flag ? 0 : n - 1; flag ? j < n : j >= 0; j += flag ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            flag = !flag;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        deque.addLast(1);
        map.put(1, 0);
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            int step = map.get(poll);
            if (poll == n * n) {
                return step;
            }
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if (np <= 0 || np > n * n) {
                    continue;
                }
                if (nums[np] != -1) {
                    np = nums[np];
                }
                if (map.containsKey(np)) {
                    continue;
                }
                map.put(np, step + 1);
                deque.addLast(np);
            }
        }
        return -1;
    }
}