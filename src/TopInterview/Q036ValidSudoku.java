package TopInterview;

class Q036ValidSudoku {

//    private boolean isRowValid(char[][] board, int row) {
//        int rows = board.length;
//        if (row == rows) {
//            return true;
//        }
//
//        final char dot = '.';
//        char char0 = '0';
//        final int len = 9;
//        int[] occurrence;
//
//        int cols = board[0].length;
//        int digit, idx;
//
//        occurrence = new int[len];
//        for (int col = 0; col < cols; ++col) {
//            digit = board[row][col];
//            idx = digit - char0 - 1;
//            if (digit != dot) {
//                if (occurrence[idx] > 0) {
//                    return false;
//                }
//                ++occurrence[idx];
//            }
//        }
//        return isRowValid(board, row + 1);
//    }
//
//    private boolean isColValid(char[][] board, int col) {
//        int cols = board[0].length;
//        if (col == cols) {
//            return true;
//        }
//        final char dot = '.';
//        char char0 = '0';
//        final int len = 9;
//        int[] occurrence;
//
//        int digit, idx;
//        int rows = board.length;
//
//        occurrence = new int[len];
//        for (int row = 0; row < rows; ++row) {
//            digit = board[row][col];
//            idx = digit - char0 - 1;
//
//            if (digit != dot) {
//                if (occurrence[idx] > 0) {
//                    return false;
//                }
//                ++occurrence[idx];
//            }
//        }
//        return isColValid(board, col + 1);
//    }
//
//    private boolean isGridValid(char[][] board) {
//        int rows = board.length;
//        int cols = board[0].length;
//        int gridSize = 3;
//
//        boolean isDigit = false;
//        boolean isFilled = false;
//        char digit;
//        char dot = '.';
//
//        for (int row = 0; row < rows; ++row) {
//            for (int col = 0; col < cols; ++col) {
//                if (row % gridSize == 0 && col % gridSize == 0) {
//                    isFilled = false;
//                    isDigit = false;
//                }
//                digit = board[row][col];
//                if (digit != dot) {
//                    isFilled = true;
//                    isDigit = true;
//                }
//
//                if (row != 0 && row % gridSize == 2) {
//                    if (col != 0 && col % gridSize == 2) {
//                        if (!isDigit && isFilled) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }

    private boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int grids = 9;
        int gridIdx;
        int size = 3;

        int range = 10;
        boolean[][] rowValid = new boolean[rows][range];
        boolean[][] colValid = new boolean[cols][range];
        boolean[][] gridValid = new boolean[grids][range];

        int idx;
        char ch, dot = '.';
        char char0 = '0';
        int i = 0, j;
        boolean valid = true;

        while (i < rows && valid) {
            j = 0;
            while (j < cols && valid) {
                ch = board[i][j];
                if (dot != ch) {
                    gridIdx = size * (i / size) + (j / size);
                    idx = board[i][j] - char0;

                    if (rowValid[i][idx] || colValid[j][idx] || gridValid[gridIdx][idx]) {
                        valid = false;
                    } else {
                        rowValid[i][idx] = true;
                        colValid[j][idx] = true;
                        gridValid[gridIdx][idx] = true;
                    }
                }
                j += valid ? 1 : 0;
            }
            i += valid ? 1 : 0;
        }
        return valid;
    }

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                ch = board[i][j];
//                if (ch != dot) {
//                    gridIdx = size * (i / size) + (j / size);
//                    idx = board[i][j] - char0;
//                    if (rowValid[i][idx] || colValid[j][idx] || gridValid[gridIdx][idx]) {
//                        return false;
//                    }
//                    rowValid[i][idx] = true;
//                    colValid[j][idx] = true;
//                    gridValid[gridIdx][idx] = true;
//                }
//            }
//        }
//        return true;

    static public void main(String... args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new Q036ValidSudoku().isValidSudoku(board));
    }
}