package meiri.leetcode1111;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int a = 0, b = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                if (a <= b) {
                    a++;
                    ans[i] = 0;
                } else {
                    b++;
                    ans[i] = 1;
                }
            } else {
                if (a >= b) {
                    a--;
                    ans[i] = 0;
                } else {
                    b--;
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }
}