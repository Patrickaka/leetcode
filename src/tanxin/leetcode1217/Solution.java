package tanxin.leetcode1217;

class Solution {
    public int minCostToMoveChips(int[] position) {
        int n = position.length;
        int a = 0;
        for (int j : position) {
            if (j % 2 == 0) {
                a++;
            }
        }
        return Math.max(a, n - a);
    }
}