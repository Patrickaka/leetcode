package zhousai.leetcode6151;

class Solution {
    long m;
    int ans = 0;
    int[] vis = new int[14];

    public int countSpecialNumbers(long n) {
        m = n;
        for (int i = 1; i < 10; i++) {
            vis[i] = 1;
            dfs(i);
            vis[i] = 0;
        }
        return ans;
    }

    void dfs(int v) {
        if (v > m) {
            return;
        }
        ans++;
        for (int i = 0; i < 10; i++) {
            if (vis[i] == 1) {
                continue;
            }
            vis[i] = 1;
            dfs(v * 10 + i);
            vis[i] = 0;
        }
    }
}