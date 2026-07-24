class Solution {

    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] box = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // Fill the boolean arrays
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int r, int c) {

        if (r == 9)
            return true;

        int nr = (c == 8) ? r + 1 : r;
        int nc = (c == 8) ? 0 : c + 1;

        if (board[r][c] != '.')
            return solve(board, nr, nc);

        int b = (r / 3) * 3 + (c / 3);

        for (int num = 1; num <= 9; num++) {

            if (!row[r][num] && !col[c][num] && !box[b][num]) {

                board[r][c] = (char) (num + '0');
                row[r][num] = true;
                col[c][num] = true;
                box[b][num] = true;

                if (solve(board, nr, nc))
                    return true;

                board[r][c] = '.';
                row[r][num] = false;
                col[c][num] = false;
                box[b][num] = false;
            }
        }

        return false;
    }
}