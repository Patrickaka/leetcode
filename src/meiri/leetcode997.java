package meiri;

class Solution997 {

    public static int findJudge(int n, int[][] trust) {
        int ans = -1;
        int[] he = new int[n + 1], cnt = new int[n + 1];
        for (int[] trusts : trust) {
            he[trusts[0]]++;
            cnt[trusts[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (he[i] == 0 && cnt[i] == n - 1) {
                ans = i;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1, 2}};
        int ans = findJudge(n, trust);
        System.out.println(ans);
    }
}