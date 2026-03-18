class Solution {
    private char[][] board;
    private String word;
    private int ROWS;
    private int COLS;
    private int[][] directions;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.directions = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        boolean[][] visited = new boolean[this.ROWS][this.COLS];

        for (int row = 0; row < this.ROWS; row++) {
            for (int col = 0; col < this.COLS; col++) {
                if (this.backtrack(row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (
            row < 0 ||
            row == this.ROWS ||
            col < 0 ||
            col == this.COLS ||
            visited[row][col] ||
            this.board[row][col] != word.charAt(index)
        ) {
            return false;
        }

        visited[row][col] = true;
        boolean res = false;

        for (int[] d : this.directions) {
            if (this.backtrack(
                row + d[0],
                col + d[1],
                index + 1,
                visited
            )) {
                res = true;
                break;
            }
        }

        visited[row][col] = false;
        return res;
    }
}