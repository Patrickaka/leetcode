package meiri.leetcode1422;

class Solution {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] n1 = new int[n + 1], n2 = new int[n + 2];
        for (int i = 1; i < n; i++) {
            n1[i] = n1[i - 1] + (chars[i - 1] == '0' ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            n2[i] = n2[i + 1] + (chars[i] == '1' ? 1 : 0);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, n1[i] + n2[i] + 1);
        }
        return ans;
    }
}