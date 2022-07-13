package moni.leetcode392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] c1 = s.toCharArray(), c2 = t.toCharArray();
        int n = c1.length, m = c2.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (c1[i] == c2[j]) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}