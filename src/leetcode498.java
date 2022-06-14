import java.util.Arrays;

class Solution {
    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length, cnt = 0;
        boolean flag = true;
        int[] result = new int[n * m];
        int i = 0, j = 0;
        while (cnt < n * m) {
            result[cnt++] = mat[i][j];
            if (flag) {
                if (i - 1 >= 0 && j + 1 < m) {
                    j += 1;
                    i -= 1;
                } else {
                    flag = false;
                    if (j + 1 < m) {
                        j += 1;
                    } else {
                        i += 1;
                    }
                }
            } else {
                if (j - 1 >= 0 && i + 1 < n) {
                    i += 1;
                    j -= 1;
                } else {
                    flag = true;
                    if (i + 1 < n) {
                        i += 1;
                    } else {
                        j += 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};1,1 -> 2,1
        int[][] mat = {{2, 5}, {8, 4}, {0, -1}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }
}