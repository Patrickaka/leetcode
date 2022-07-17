package tulun.leetcode765;

class Solution {

    int[] h = new int[35];

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] row = {1, 4, 0, 5, 8, 7, 6, 3, 2, 9};
        System.out.println(solution.minSwapsCouples(row));
    }

    void union(int x, int y) {
        h[find(x)] = h[find(y)];
    }

    int find(int x) {
        if (x != h[x]) {
            h[x] = find(h[x]);
        }
        return h[x];
    }

    public int minSwapsCouples(int[] row) {
        int cnt = 0, n = row.length, m = n / 2;
        for (int i = 0; i < m; i++) {
            h[i] = i;
        }
        for (int i = 0; i < n - 1; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        for (int i = 0; i < m; i++) {
            if (find(i) == i) {
                cnt++;
            }
        }
        return m - cnt;
    }
}