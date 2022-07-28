package review.meiri.lc;

import java.util.Arrays;

class Solution {

    int idx = 0;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    static int M = (int) 1e5 + 10, N = M * 2;

    public int countHighestScoreNodes(int[] parents) {
        Arrays.fill(he, -1);
        int n = parents.length;
        for (int i = 1; i < n; i++) {
            add(parents[i], i);
        }
        dfs(0);
        long max = 0;
        int ans = 0;
        for (int x = 0; x < n; x++) {
            long cur = 1;
            for (int i = he[x]; i != -1; i = ne[i]) {
                cur *= f[e[i]];
            }
            if (x != 0) {
                cur *= n - f[x];
            }
            if (cur > max) {
                max = cur;
                ans = 1;
            } else if (cur == max) {
                ans++;
            }
        }
        return ans;
    }

    static int[] f = new int[M];

    int dfs(int x) {
        int ans = 1;
        for (int i = he[x]; i != -1; i = ne[i]) {
            ans += dfs(e[i]);
        }
        f[x] = ans;
        return ans;
    }

    static int[] he = new int[M], ne = new int[N], e = new int[N];


}
