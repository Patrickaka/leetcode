class Solution1395 {

    static int N = (int) 1e5 + 10;
    static int[] tr = new int[N];

    int lowbit(int x) {
        return x & -x;
    }

    void update(int x, int v) {
        for (int i = x; i < N; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tr[i];
        }
        return ans;
    }

    public int numTeams(int[] rating) {
        int n = rating.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int a = rating[i];
            for (int j = i + 1; j < n; j++) {
                int b = rating[j];
                if (a < b) {
                    ans += query(b - 1) - query(a);
                } else {
                    ans += query(a - 1) - query(b);
                }
                update(b, 1);
            }
            for (int j = i + 1; j < n; j++) {
                update(rating[j], -1);
            }
        }
        return ans;
    }
}