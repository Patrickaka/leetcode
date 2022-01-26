import java.util.Arrays;

class Solution743Floyd {
    static int N = 101, M = 6010, INF = 0x3f3f3f3f;
    int[][] w = new int[N][N];

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                w[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            w[a][b] = c;
        }
        floyd(n, k);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.min(ans, w[k][i]);
        }
        return ans;
    }

    private void floyd(int n, int k) {
        for (int p = 1; p <= N; p++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }
}

class Solution743Dijkstra {
    static int N = 101, M = 6001, INF = 0x3f3f3f3f;
    int[][] w = new int[N][N];
    int[] dist = new int[N];
    boolean[] vis = new boolean[N];

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                w[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            w[a][b] = c;
        }
        dijkstra(n, k);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF ? -1 : ans;
    }

    private void dijkstra(int n, int k) {
        Arrays.fill(dist, INF);
        Arrays.fill(vis, false);
        dist[k] = 0;
        for (int p = 1; p <= n; p++) {
            int t = -1;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) {
                    t = i;
                }
            }
            vis[t] = true;
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
            }
        }
    }
}