package recursion;

class Q01EightQueue {

    private int count = 0;

    private void placeQueue(int[] board, int row) {
        if (row == board.length) {
            // 1 solution found
            printBoard(board);
            System.out.println();
            ++count;
            return;
        }
        int size = board.length;
        boolean valid;
        for (int col = 1; col <= size; ++col) {
            board[row] = col;
            valid = validate(board, row, col);
            if (valid) {
                placeQueue(board, row + 1);
            }
        }
    }

    private void printBoard(int[] board) {
        if (null == board || board.length <= 0) {
            return;
        }
        int size = board.length;
        final char x = 'X';
        final char o = 'O';
        final char space = ' ';
        for (int spot : board) {
            for (int col = 1; col <= size; ++col) {
                if (col == spot) {
                    System.out.print(x);
                } else {
                    System.out.print(o);
                }

                if (col == size) {
                    System.out.println();
                } else {
                    System.out.print(space);
                }
            }
        }
    }

    private boolean validate(int[] board, int row, int col) {
        int prevRow = row - 1;
        int prevCol;
        boolean valid = true;
        while (prevRow >= 0 && (valid = (prevCol = board[prevRow]) != col && Math.abs(row - prevRow) != Math.abs(col - prevCol))) {
            --prevRow;
        }
        return valid;
    }

    static public void main(String... args) {
        final int size = 8;
        int[] board = new int[size];
        Q01EightQueue obj = new Q01EightQueue();
        int row = 0;
        obj.placeQueue(board, row);

        System.out.println("solution: " + obj.count);
    }
}