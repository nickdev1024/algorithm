package code;

class Q004SudokuSolver {

    private boolean solve(int[][] board, int row, int col, boolean[][] validRow, boolean[][] validCol, boolean[][] validGrid) {
        int rows = board.length;
        int cols = board[0].length;

        if (col == cols) {
            col = 0;
            if (++row == rows) {
                return true;
            }
        }
        if (board[row][col] != 0) {
            return solve(board, row, col + 1, validRow, validCol, validGrid);
        } else {
            int range = 9;
            int idx;
            if (board[row][col] == 0) {
                idx = row / 3 * 3 + col / 3;
                for (int val = 1; val <= range; ++val) {
                    if (!validRow[row][val] && !validCol[col][val] && !validGrid[idx][val]) {
                        board[row][col] = val;
                        validRow[row][val] = true;
                        validCol[col][val] = true;
                        validGrid[idx][val] = true;
                        if (solve(board, row, col + 1, validRow, validCol, validGrid)) {
                            return true;
                        }
                        validRow[row][val] = false;
                        validCol[col][val] = false;
                        validGrid[idx][val] = false;
                        board[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }

    private void solveSudoku(int[][] board) {
        if (null == board || board.length == 0 || null == board[0] || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        // for each row, each column, each grid, it has value range from 1 - 9
        int size = 10;
        boolean[][] validRow = new boolean[rows][size];
        boolean[][] validCol = new boolean[cols][size];
        boolean[][] validGrid = new boolean[size][size];

        scanUpdate(board, validRow, validCol, validGrid);
        solve(board, 0, 0, validRow, validCol, validGrid);
    }

    private void scanUpdate(int[][] board, boolean[][] validRow, boolean[][] validCol, boolean[][] validGrid) {
        int rows = board.length;
        int cols = board[0].length;
        int zero = 0;
        int value, idx;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                idx = i / 3 * 3 + j / 3;
                value = board[i][j];
                if (zero != value) {
                    validRow[i][value] = true;
                    validCol[j][value] = true;
                    validGrid[idx][value] = true;
                }
            }
        }
    }

    private void validate() {
        int[][] board = {
                {8, 9, 0, 0, 0, 0, 1, 6, 5},
                {0, 1, 0, 3, 5, 8, 0, 2, 0},
                {0, 2, 4, 1, 9, 0, 0, 0, 0},
                {4, 0, 5, 0, 8, 1, 0, 0, 0},
                {1, 0, 9, 0, 0, 2, 5, 0, 8},
                {0, 0, 8, 4, 0, 5, 0, 3, 1},
                {6, 0, 0, 0, 7, 0, 0, 0, 0},
                {3, 8, 1, 5, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 8, 5, 2}
        };
        solveSudoku(board);
        print(board);
    }

    private void print(int[][] board) {
        if (null == board || board.length == 0 || null == board[0] || board[0].length == 0) {
            return;
        }
        int cols = board[0].length;
        String space = " ";
        int col;
        for (int[] row : board) {
            col = 0;
            for (int val : row) {
                System.out.print(val);
                if (++col != cols) {
                    System.out.print(space);
                }
            }
            System.out.println();
        }
    }

    static public void main(String... args) {
        new Q004SudokuSolver().validate();
    }
}