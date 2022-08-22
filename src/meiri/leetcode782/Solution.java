package meiri.leetcode782;

class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length, rowSum = 0, colSum = 0, rowDiff = 0, colDiff = 0;
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            rowDiff += (board[i][0] == i % 2) ? 1 : 0;
            colDiff += (board[0][i] == i % 2) ? 1 : 0;
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        if (n / 2 > rowSum || rowSum > (n + 1) / 2) {
            return -1;
        }
        if (n / 2 > colSum || colSum > (n + 1) / 2) {
            return -1;
        }
        if (n % 2 == 1) {
            if (rowDiff % 2 == 1) {
                rowDiff = n - rowDiff;
            }
            if (colDiff % 2 == 1) {
                colDiff = n - colDiff;
            }
        } else {
            rowDiff = Math.min(n - rowDiff, rowDiff);
            colDiff = Math.min(n - colDiff, colDiff);
        }
        return (rowDiff + colDiff) / 2;
    }
}