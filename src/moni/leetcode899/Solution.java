package moni.leetcode899;

class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < k; i++) {
            while (i + 1 < n && s.charAt(i + 1) < s.charAt(i)) {
                char temp = s.charAt(i);
                s = s.substring(0, i) + s.substring(i + 1) + temp;
            }
        }
        return s;
    }
}