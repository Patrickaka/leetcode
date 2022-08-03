package meiri;

class Solution419 {
    public static int countBattleships(char[][] board) {
        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    boolean right = j + 1 >= n || board[i][j + 1] != 'X';
                    boolean down = i + 1 >= m || board[i + 1][j] != 'X';
                    if (right && down) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        int ans = countBattleships(board);
        System.out.println(ans);
    }
}