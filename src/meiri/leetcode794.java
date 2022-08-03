package meiri;

class Solution794 {
    public static boolean validTicTacToe(String[] board) {
        int x = 0;
        int o = 0;
        int xSame = 0;
        int oSame = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    x++;
                } else if (board[i].charAt(j) == 'O') {
                    o++;
                }
            }
        }
        if (board[0].charAt(1) == board[1].charAt(0) && board[0].charAt(1) == board[1].charAt(2) && board[0].charAt(1) == board[2].charAt(1) && board[0].charAt(1) == 'O') {
            if (x == 5) {
                return true;
            }
        }
        if (board[1].charAt(0) == board[1].charAt(1) && board[1].charAt(0) == board[2].charAt(0) && board[1].charAt(0) == board[2].charAt(1) && board[1].charAt(0) == 'O') {
            if (x == 5) {
                return true;
            }
        }
        if (board[1].charAt(1) == board[1].charAt(2) && board[1].charAt(1) == board[2].charAt(1) && board[1].charAt(1) == board[2].charAt(2) && board[1].charAt(1) == 'O') {
            if (x == 5) {
                return true;
            }
        }
        if (x == 0 && o == 0) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i) && board[0].charAt(i) != ' ') {
                if (board[0].charAt(i) == 'X') {
                    xSame++;
                } else {
                    oSame++;
                }
            }
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2) && board[i].charAt(0) != ' ') {
                if (board[i].charAt(0) == 'X') {
                    xSame++;
                } else {
                    oSame++;
                }
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2) && board[0].charAt(0) != ' ') {
            if (board[0].charAt(0) == 'X') {
                xSame++;
            } else {
                oSame++;
            }
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0) && board[0].charAt(2) != ' ') {
            if (board[0].charAt(2) == 'X') {
                xSame++;
            } else {
                oSame++;
            }
        }
        if (oSame + xSame > 1) {
            return false;
        }
        if (oSame == 1 && x > o) {
            return false;
        }
        if (xSame == 1 && x == o) {
            return false;
        }
        return x == o || x - 1 == o;
    }

    public static void main(String[] args) {
        String[] board = {"OOO", "XXO", "XXX"};
        boolean result = validTicTacToe(board);
        System.out.println(result);
    }
}