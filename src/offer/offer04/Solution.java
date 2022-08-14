package offer.offer04;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean res = false;
        int n = matrix.length, m = matrix[0].length;
        int row = 0, column = m - 1;
        while (row < n && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return res;
    }
}