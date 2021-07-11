package TopInterview;

class Q048RotateImage {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int topRow = 0;
        int topCol = 0;
        int downRow = rows - 1;
        int downCol = cols - 1;

        while (topRow < downRow) {
            rotateEdge(matrix, topRow++, topCol++, downRow--, downCol--);
        }
    }

    private void rotateEdge(int[][] matrix, int topRow, int topCol, int downRow, int downCol) {
        int tmp;
        int groups = downCol - topCol;

        for (int i = 0; i < groups; ++i) {
            tmp = matrix[topRow][topCol + i];
            matrix[topRow][topCol + i] = matrix[downRow - i][topCol];
            matrix[downRow - i][topCol] = matrix[downRow][downCol - i];
            matrix[downRow][downCol - i] = matrix[topRow + i][downCol];
            matrix[topRow + i][downCol] = tmp;
        }
    }

    private void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        String space = " ";
        for (int row = 0; row < rows; ++row) {
            System.out.print(matrix[row][0]);
            for (int col = 1; col < cols; ++col) {
                System.out.print(space + matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void validate() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);

        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }

    static public void main(String... args) {
        new Q048RotateImage().validate();
    }
}