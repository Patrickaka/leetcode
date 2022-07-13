package tulun.leetcode773.Astar;

import java.util.*;

class Solution {

    String target = "123450";
    int n = 2, m = 3;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(solution.slidingPuzzle(board));
    }

    public int slidingPuzzle(int[][] board) {
        int[][] positions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Map<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]);
            }
        }
        if (!check(sb.toString())) {
            return -1;
        }
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        map.put(sb.toString(), 0);
        q.add(new Node(sb.toString(), f(sb.toString())));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int step = map.get(node.str);
            if (node.str.equals(target)) {
                return step;
            }
            int x = -1, y = -1;
            for (int i = 0; i < node.str.length(); i++) {
                if (node.str.charAt(i) == '0') {
                    x = i / 3;
                    y = i % 3;
                }
            }
            for (int[] position : positions) {
                int dx = x + position[0], dy = y + position[1];
                if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
                    continue;
                }
                String nstr = swap(node.str, x * m + y, dx * m + dy);
                if (!map.containsKey(nstr) || map.get(nstr) > step + 1) {
                    map.put(nstr, step + 1);
                    q.add(new Node(nstr, step + 1 + f(nstr)));
                }
            }
        }
        return -1;
    }

    int f(String str) {
        int ans = 0;
        char[] c1 = str.toCharArray(), c2 = target.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c1[i * m + j] == '0' || c2[i * m + j] == '0') {
                    continue;
                }
                int a = c1[i * m + j], b = c2[i * m + j];
                int xd = Math.abs((a) / 3 - (b) / 3);
                int yd = Math.abs((a) % 3 - (b) % 3);
                ans += (xd + yd);
            }
        }
        return ans;
    }

    String swap(String str, int i, int j) {
        char[] a = str.toCharArray();
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return String.valueOf(a);
    }

    boolean check(String str) {
        char[] cs = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n * m; i++) {
            if (cs[i] != '0') {
                list.add(cs[i] - '0');
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    cnt++;
                }
            }
        }
        return cnt % 2 == 0;
    }

    static class Node {
        String str;
        int distance;

        public Node(String str, int distance) {
            this.str = str;
            this.distance = distance;
        }
    }
}
