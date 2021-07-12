package TopInterview;

class Q073SetMatrixZeroes {

    public void setZeroes1(int[][] matrix) {
        // only use 1 variable instead of 2-d array
        // if column 0 should be set to 0 or not, yes if true, false otherwise
        boolean col00 = false;

        int row, col;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (row = 0; row < rows; ++row) {
            for (col = 0; col < cols; ++col) {
                if (matrix[row][col] == 0) {
                    if (col != 0) {
                        matrix[0][col] = 0;
                        matrix[row][0] = 0;
                    } else {
                        col00 = true;
                    }
                }
            }
        }
        for (row = rows - 1; row >= 0; --row) {
            for (col = 1; col < cols; ++col) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (col00) {
            for (row = rows - 1; row >= 0; --row) {
                matrix[row][0] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        // only use 2 variable instead of 2-d array
        // if row 0 should be set to 0 or not, yes if true, false otherwise
        // if column 0 should be set to 0 or not, yes if true, false otherwise
        boolean row00 = false;
        boolean col00 = false;

        int row = 0, col = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (col < cols && !row00) {
            row00 = matrix[0][col++] == 0;
        }
        while (row < rows && !col00) {
            col00 = matrix[row++][0] == 0;
        }

        for (row = 1; row < rows; ++row) {
            for (col = 1; col < cols; ++col) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (row = 1; row < rows; ++row) {
            for (col = 1; col < cols; ++col) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (row00) {
            for (col = 0; col < cols; ++col) {
                matrix[0][col] = 0;
            }
        }
        if (col00) {
            for (row = 0; row < rows; ++row) {
                matrix[row][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int zero = 0;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (!visited[row][col]) {
                    if (matrix[row][col] == zero) {
                        setRow(matrix, row, zero, visited);
                        setCol(matrix, col, zero, visited);
                    }
                    visited[row][col] = true;
                }
            }
        }
    }

    private void setRow(int[][] matrix, int row, int zero, boolean[][] visited) {
        int cols = matrix[0].length;
        for (int col = 0; col < cols; col++) {
            if (matrix[row][col] != zero) {
                matrix[row][col] = zero;
                visited[row][col] = true;
            }
        }
    }

    private void setCol(int[][] matrix, int col, int zero, boolean[][] visited) {
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            if (matrix[row][col] != zero) {
                matrix[row][col] = zero;
                visited[row][col] = true;
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        int cols = matrix[0].length;
        String space = " ";

        for (int[] row : matrix) {
            System.out.print(row[0]);
            for (int col = 1; col < cols; ++col) {
                System.out.print(space + row[col]);
            }
            System.out.println();
        }
    }

    private void validate() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes2(matrix);
        printMatrix(matrix);

        System.out.println();

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes2(matrix);
        printMatrix(matrix);
    }

    static public void main(String... args) {
        Q073SetMatrixZeroes obj = new Q073SetMatrixZeroes();
        obj.validate();
    }
}