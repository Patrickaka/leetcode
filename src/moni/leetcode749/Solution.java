package moni.leetcode749;

import java.util.*;

class Solution {

    int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[][] isInfected;
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> ((b[2] - b[3]) - (a[2] - a[3])));
    boolean[][] inf;
    boolean[][] vis;
    int m, n, cnt;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution.containVirus(arr));
    }

    public int containVirus(int[][] isInfected) {
        int ans = 0;
        m = isInfected.length;
        n = isInfected[0].length;
        this.isInfected = isInfected;
        inf = new boolean[m][n];
        vis = new boolean[m][n];
        getMax();
        while (!queue.isEmpty() && queue.peek()[2] > 0) {
            int[] p = queue.poll();
            ans += p[2];
            clear();
            dfs(p[0], p[1], true, new ArrayList<>());
            while (!queue.isEmpty()) {
                clear();
                int[] poll = queue.poll();
                List<Integer> list = map.get(poll[0] * n + poll[1]);
                for (int l : list) {
                    int x = l / n, y = l % n;
                    isInfected[x][y] = 1;
                }
            }
            clear();
            map.clear();
            getMax();
        }
        return ans;
    }

    int dfs(int x, int y, boolean cl, List<Integer> list) {
        int ans = 0;
        for (int[] pos : positions) {
            int nx = x + pos[0], ny = y + pos[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (isInfected[nx][ny] == 0) {
                if (vis[nx][ny]) {
                    cnt++;
                }
                list.add(nx * n + ny);
                vis[nx][ny] = true;
                ans++;
            }
            if (isInfected[nx][ny] == 1 && !inf[nx][ny]) {
                if (cl) {
                    isInfected[nx][ny] = -1;
                }
                inf[nx][ny] = true;
                ans += dfs(nx, ny, cl, list);
            }
        }
        return ans;
    }

    void clear() {
        for (int idx = 0; idx < m; idx++) {
            Arrays.fill(inf[idx], false);
        }
        for (int idx = 0; idx < m; idx++) {
            Arrays.fill(vis[idx], false);
        }
        cnt = 0;
    }

    void getMax() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isInfected[i][j] == 1 && !inf[i][j]) {
                    inf[i][j] = true;
                    List<Integer> list = new ArrayList<>();
                    int num = dfs(i, j, false, list);
                    map.put(i * n + j, list);
                    queue.add(new int[]{i, j, num, cnt});
                    for (int idx = 0; idx < m; idx++) {
                        Arrays.fill(vis[idx], false);
                    }
                    cnt = 0;
                }
            }
        }
    }
}