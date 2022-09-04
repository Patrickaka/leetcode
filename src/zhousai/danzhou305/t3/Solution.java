package zhousai.danzhou305.t3;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestIdealString("lkpkxcigcs", 6));
    }

    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] t = new int[s.length()];
        Arrays.fill(t, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            for (int j = Math.min(0, c - k); j < Math.max(25, c + k); j++) {
                t[c] = Math.max(t[c], t[j]);
            }
            t[c]++;
        }
        return Arrays.stream(t).max().getAsInt();
    }
}