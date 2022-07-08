package review;

import java.util.Scanner;

public class meituan {

    static int N = 50010;
    static int[] tr = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] w = new int[n], h = new int[n], ans = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            add(i + 1, w[i]);
        }
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            add(h[i], -w[h[i] - 1]);
            int left = query(h[i] - 1) - query(0);
            int right = query(n) - query(h[i]);
            ans[i] = Math.max(left, right);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    private static void add(int x, int val) {
        for (int i = x; i < N; i += lowbit(i)) {
            tr[i] += val;
        }
    }

    private static int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tr[i];
        }
        return ans;
    }
}
