package TopInterview;

class Q073SetMatrixZeroes {

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

    static public void main(String... args) {
        Q073SetMatrixZeroes obj = new Q073SetMatrixZeroes();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        obj.setZeroes(matrix);

        System.out.println("fdaf");
        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        obj.setZeroes(matrix);
        System.out.println("fdaf");
    }
}