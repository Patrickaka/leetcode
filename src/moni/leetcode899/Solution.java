package moni.leetcode899;

import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        if (k == 1) {
            int cnt = 0, i = 0, j = 1;
            while (cnt < n && i < n && j < n) {
                if (cs[(i + k) % n] == cs[(j + k) % n]) {
                    k++;
                } else {
                    if (cs[(i + k) % n] > cs[(j + k) % n]) {
                        i = i + k + 1;
                    } else {
                        j = j + k + 1;
                    }
                    if (i == j) {
                        i += 1;
                    }
                    k = 0;
                }
            }
            i = Math.min(i, j);
            System.out.println(i);
            return s.substring(i) + s.substring(0, i);
        } else {
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}