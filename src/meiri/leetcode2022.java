package meiri;

class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        int area = m * n;
        if (area != original.length) {
            return new int[0][0];
        }
        int flag = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag == original.length) {
                    flag = original.length - 1;
                }
                ans[i][j] = original[flag++];
            }
        }
        return ans;
    }
}