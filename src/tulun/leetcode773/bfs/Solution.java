package tulun.leetcode773.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    String target = "123450";

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(solution.slidingPuzzle(board));
    }

    public int slidingPuzzle(int[][] board) {
        int[] positions = {-1, 1, -3, 3};
        Map<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        if (sb.toString().equals(target)) {
            return 0;
        }
        deque.addLast(sb.toString());
        map.put(sb.toString(), 0);
        while (!deque.isEmpty()) {
            String str = deque.pollFirst();
            int step = map.get(str);
            int a = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    a = i;
                    break;
                }
            }
            for (int p : positions) {
                if ((a == 2 || a == 5) && p == 1) {
                    continue;
                }
                if ((a == 0 || a == 3) && p == -1) {
                    continue;
                }
                if (a + p < 0 || a + p > 5) {
                    continue;
                }
                String nstr = swap(str, a, a + p);
                if (nstr.equals(target)) {
                    return step + 1;
                }
                if (map.containsKey(nstr)) {
                    continue;
                }
                deque.addLast(nstr);
                map.put(nstr, step + 1);
            }
        }
        return -1;
    }

    String swap(String str, int i, int j) {
        char[] a = str.toCharArray();
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        StringBuilder sb = new StringBuilder();
        for (char c : a) {
            sb.append(c);
        }
        return sb.toString();
    }
}
