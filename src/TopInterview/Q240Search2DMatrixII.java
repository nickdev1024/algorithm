package TopInterview;

class Q240Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        int val;
        boolean found = false;
        while (row < rows && col >= 0 && !found) {
            val = matrix[row][col];
            if (val < target) {
                ++row;
            } else if (val > target) {
                --col;
            } else {
                found = true;
            }
        }
        return found;
    }

    static public void main(String... args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        Q240Search2DMatrixII obj = new Q240Search2DMatrixII();
        System.out.println(obj.searchMatrix(matrix, target));
        target = 20;
        System.out.println(obj.searchMatrix(matrix, target));
    }
}