class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;
    private int[][] directions;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.directions = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        for (int row = 0; row < this.ROWS; row++) {
            for (int col = 0; col < this.COLS; col++) {
                if (this.backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        if (
            row < 0 ||
            row == this.ROWS ||
            col < 0 ||
            col == this.COLS ||
            this.board[row][col] != word.charAt(index)
        ) {
            return false;
        }

        boolean res = false;
        this.board[row][col] = '#';

        for (int[] d : this.directions) {
            if (this.backtrack(
                row + d[0],
                col + d[1],
                word, index + 1
            )) {
                res = true;
                break;
            }
        }

        this.board[row][col] = word.charAt(index);
        return res;
    }
}