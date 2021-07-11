package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q054SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int topRow = 0;
        int topCol = 0;
        int downRow = rows - 1;
        int downCol = cols - 1;

        while (topRow <= downRow && topCol <= downCol) {
            insert(list, matrix, topRow++, topCol++, downRow--, downCol--);
        }
        return list;
    }

    private void insert(List<Integer> list, int[][] matrix, int topRow, int topCol, int downRow, int downCol) {
        if (topRow == downRow) {
            for (int col = topCol; col <= downCol; col++) {
                list.add(matrix[topCol][col]);
            }
        } else if (topCol == downCol) {
            for (int row = topRow; row <= downRow; row++) {
                list.add(matrix[row][topCol]);
            }
        } else {
            for (int col = topCol; col < downCol; col++) {
                list.add(matrix[topRow][col]);
            }
            for (int row = topRow; row < downRow; row++) {
                list.add(matrix[row][downCol]);
            }
            for (int col = downCol; col > topCol; --col) {
                list.add(matrix[downRow][col]);
            }
            for (int row = downRow; row > topRow; --row) {
                list.add(matrix[row][topCol]);
            }
        }
    }

    private void printList(List<Integer> list) {
        if (null == list || list.size() == 0) {
            return;
        }
        int idx = 0;
        System.out.print(list.get(idx));
        int size = list.size();
        String space = " ";
        for (idx = 1; idx < size; idx++) {
            System.out.print(space + list.get(idx));
        }
        System.out.println();
    }

    private void validate() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> list;
        list = spiralOrder(matrix);
        printList(list);
        matrix = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        list = spiralOrder(matrix);
        printList(list);
        matrix = new int[][]{
                {7}, {9}, {6}
        };
        list = spiralOrder(matrix);
        printList(list);
        matrix = new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        list = spiralOrder(matrix);
        printList(list);
    }

    static public void main(String... args) {
        new Q054SpiralMatrix().validate();
    }
}