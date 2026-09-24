class Solution {
    int w, h;
    char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        w = board[0].length;
        h = board.length;
        for (int i = 0; i < w; i++) {
            mark(0, i);
            mark(h - 1, i);
        }
        for (int j = 0; j < h; j++) {
            mark(j, 0);
            mark(j, w - 1);
        }

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'S')
                    board[r][c] = 'O';
            }
        }
    }

    private void mark(int r, int c) {
        if (r < 0 || r >= h || c < 0 || c >= w) return;
        if (board[r][c] != 'O') return;
        board[r][c] = 'S';
        mark(r - 1, c);
        mark(r, c - 1);
        mark(r + 1, c);
        mark(r, c + 1);
    }
}
