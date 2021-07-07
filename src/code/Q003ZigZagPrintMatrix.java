package code;

class Q003ZigZagPrintMatrix {

    private void printZigZag(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        boolean up = false;

        while (endX != rows) {
            print(matrix, startX, startY, endX, endY, up = !up);
            endX += endY != cols - 1 ? 0 : 1;
            endY += endY != cols - 1 ? 1 : 0;
            startY += startX != rows - 1 ? 0 : 1;
            startX += startX != rows - 1 ? 1 : 0;
        }
    }

    private void print(int[][] matrix, int startX, int startY, int endX, int endY, boolean up) {
        String space = " ";
        if (up) {
            do {
                System.out.print(matrix[startX][startY] + space);
            } while (startX-- != endX && startY++ != endY);
        } else {
            do {
                System.out.print(matrix[endX][endY] + space);
            } while (endX++ != startX && endY-- != startY);
        }
    }

    private void validate() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printZigZag(matrix);
    }

    static public void main(String... args) {
        new Q003ZigZagPrintMatrix().validate();
    }
}