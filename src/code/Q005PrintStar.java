package code;

class Q005PrintStar {

    private void printStar(int num) {
        int leftUp = 0;
        int downRight = num - 1;
        char[][] matrix = new char[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = ' ';
            }
        }

        while (leftUp <= downRight) {
            setup(matrix, leftUp, downRight);
            leftUp += 2;
            downRight -= 2;
        }

        String space = " ";
        for (int i = 0; i < num; i++) {
            System.out.print(matrix[i][0]);
            for (int j = 1; j < num; j++) {
                System.out.print(space + matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void setup(char[][] matrix, int leftUp, int downRight) {
        // 1
        for (int col = leftUp; col <= downRight; col++) {
            matrix[leftUp][col] = '*';
        }
        for (int row = leftUp + 1; row <= downRight; row++) {
            matrix[row][downRight] = '*';
        }
        for (int col = downRight - 1; col > leftUp; col--) {
            matrix[downRight][col] = '*';
        }
        for (int row = downRight - 1; row > leftUp + 1; row--) {
            matrix[row][leftUp + 1] = '*';
        }
    }

    static public void main(String... args) {
        new Q005PrintStar().printStar(20);
    }
}