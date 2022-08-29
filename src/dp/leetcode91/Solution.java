package dp.leetcode91;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("10011"));
    }

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            boolean ok = Integer.parseInt(s.substring(i - 1, i + 1)) <= 26;
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
                if (i >= 2 && s.charAt(i - 1) != '0' && ok) {
                    dp[i] += dp[i - 2];
                } else if (i == 1 && ok) {
                    dp[i]++;
                }
            } else {
                if (s.charAt(i - 1) != '0' && ok) {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    return 0;
                }
            }
        }
        return dp[n - 1];
    }
}