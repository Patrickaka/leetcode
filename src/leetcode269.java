import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution269 {
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        out[a]++;
        in[b]++;
    }

    int N = 26, M = N * N, idx = 0, cnt = 0;

    public String alienOrder(String[] ws) {

        int n = ws.length;
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (char c : ws[i].toCharArray()) {
                if (!vis[c - 'a'] && ++cnt >= 0) {
                    vis[c - 'a'] = true;
                }
            }
            for (int j = 0; j < i; j++) {
                if (!build(ws[j], ws[i])) {
                    return "";
                }
            }
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] && in[i] == 0) {
                d.addLast(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) {
            int u = d.pollFirst();
            sb.append((char) (u + 'a'));
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) {
                    d.addLast(j);
                }
            }
        }
        return sb.length() == cnt ? sb.toString() : "";
    }

    int[] he = new int[N], e = new int[M], ne = new int[M];

    boolean build(String a, String b) {
        int n = a.length(), m = b.length(), len = Math.min(n, m);
        for (int i = 0; i < len; i++) {
            int c1 = a.charAt(i) - 'a', c2 = b.charAt(i) - 'a';
            if (c1 != c2) {
                add(c1, c2);
                return true;
            }
        }
        return n <= m;
    }

    int[] in = new int[N], out = new int[N];
    boolean[] vis = new boolean[N];


}