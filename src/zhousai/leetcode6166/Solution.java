package zhousai.leetcode6166;

import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPalindromic("00000"));
    }

    public String largestPalindromic(String s) {
        TreeMap<Character, Integer> counter = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.merge(s.charAt(i), 1, Integer::sum);
        }
        if (counter.size() == 1 && counter.firstKey() == '0') {
            return "0";
        }
        // 统计构造回文串的最大长度
        StringBuilder lsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        char max = ' ';
        int zerosum = 0;
        while (!counter.isEmpty()) {
            Character c = counter.lastKey();
            if (c == '0' && lsb.length() == 0) {
                zerosum = counter.get(c);
                counter.remove(c);
                continue;
            }
            if (lsb.length() != 0) {
                if (zerosum % 2 == 0) {
                    for (int i = 0; i < zerosum / 2; i++) {
                        lsb.append(c);
                        rsb.insert(0, c);
                    }
                } else {
                    if (max == ' ' || c > max) {
                        max = c;
                    }
                    for (int i = 0; i < (zerosum - 1) / 2; i++) {
                        lsb.append(c);
                        rsb.insert(0, c);
                    }
                }
                zerosum = 0;
            }
            int count = counter.get(c);
            if (count % 2 == 0) {
                for (int i = 0; i < count / 2; i++) {
                    lsb.append(c);
                    rsb.insert(0, c);
                }
            } else {
                if (c > max) {
                    max = c;
                }
                for (int i = 0; i < (count - 1) / 2; i++) {
                    lsb.append(c);
                    rsb.insert(0, c);
                }
            }
            counter.remove(c);
        }
        return lsb.toString() + (max == ' ' ? "" : max) + rsb;
    }
}