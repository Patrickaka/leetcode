import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    static int INF = 0x3f3f3f3f;

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        int[][] dist = new int[mask][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dist[1 << i][0] = 0;
            deque.addLast(new int[]{i << n, i});
        }
        while (!deque.isEmpty()) {
            int[] p = deque.pollFirst();
            int state = p[0], u = p[1], step = dist[state][u];
            if (state == mask - 1) {
                return step;
            }
            for (int i : graph[u]) {
                if (dist[state | (1 << i)][i] == INF) {
                    dist[state | (1 << i)][i] = step + 1;
                    deque.addLast(new int[]{state | (1 << i), i});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int mask = 1 << 3;
        System.out.println(mask);
    }
}