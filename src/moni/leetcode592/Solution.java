package moni.leetcode592;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String s = "-1/2+1/2+1/3";
        Solution solution = new Solution();
        System.out.println(solution.fractionAddition(s));
    }

    public String fractionAddition(String expression) {
        List<int[]> list = new ArrayList<>();
        int maxNum = 1;
        int fenzi = 0;
        char[] cs = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            if (i == cs.length - 1) {
                sb.append(cs[i]);
                int fenmu = Integer.parseInt(sb.toString());
                if (maxNum % fenmu != 0) {
                    maxNum = fenmu * maxNum;
                }
                int[] arr = new int[]{fenzi, fenmu};
                list.add(arr);
                break;
            }
            if (cs[i] >= '0' && cs[i] <= '9') {
                sb.append(cs[i]);
                continue;
            }
            if (cs[i] == '/') {
                fenzi = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            if (cs[i] == '+' || cs[i] == '-') {
                int fenmu = Integer.parseInt(sb.toString());
                if (maxNum % fenmu != 0) {
                    maxNum = fenmu * maxNum;
                }
                int[] arr = new int[]{fenzi, fenmu};
                list.add(arr);
                sb = new StringBuilder();
                if (cs[i] == '-') {
                    sb.append(cs[i]);
                }
            }
        }
        int sum = 0;
        for (int[] arr : list) {
            sum += ((maxNum / arr[1]) * arr[0]);
        }
        sb = new StringBuilder();
        int c = gcd(Math.abs(sum), maxNum);
        sb.append(sum / c).append('/').append(maxNum / c);
        return sb.toString();
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}