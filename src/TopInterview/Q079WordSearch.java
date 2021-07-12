package TopInterview;

class Q079WordSearch {

    public boolean exist(char[][] board, String word) {
        if (null == word || word.isEmpty() || null == board || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        char[] target = word.toCharArray();

        int rows = board.length;
        int cols = board[0].length;
        boolean found = false;
        int row = 0, col;
        while (row < rows && !found) {
            col = 0;
            while (col < cols && !found) {
                found = search(board, row, col, rows, cols, target, 0);
                if (!found) {
                    ++col;
                }
            }
            if (!found) {
                ++row;
            }
        }
        return found;
    }

    private boolean search(char[][] board, int row, int col, int rows, int cols, char[] target, int idx) {
        if (idx == target.length) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        if (board[row][col] != target[idx]) {
            return false;
        }
        char tmp = board[row][col];
        board[row][col] = 1;

        boolean found = search(board, row - 1, col, rows, cols, target, idx + 1)
                || search(board, row + 1, col, rows, cols, target, idx + 1)
                || search(board, row, col - 1, rows, cols, target, idx + 1)
                || search(board, row, col + 1, rows, cols, target, idx + 1);
        board[row][col] = tmp;
        return found;
    }

    public boolean exist1(char[][] board, String word) {
        if (null == word || word.isEmpty() || null == board || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        char[] str = word.toCharArray();
        int idx = 0;
        int rows = board.length;
        int cols = board[0].length;
        boolean found = false;
        int row = 0, col;
        boolean[][] visited = new boolean[rows][cols];
        while (row < rows && !found) {
            col = 0;
            while (col < cols && !found) {
                found = search1(board, row, col, rows, cols, str, idx, visited);
                if (!found) {
                    ++col;
                }
            }
            if (!found) {
                ++row;
            }
        }
        return found;
    }

    private boolean search1(char[][] board, int row, int col, int rows, int cols, char[] str, int idx, boolean[][] visited) {
        // found the word
        if (idx == str.length) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        boolean found = false;
        if (board[row][col] == str[idx] && !visited[row][col]) {
            visited[row][col] = true;
            found = search1(board, row - 1, col, rows, cols, str, idx + 1, visited)
                    || search1(board, row + 1, col, rows, cols, str, idx + 1, visited)
                    || search1(board, row, col - 1, rows, cols, str, idx + 1, visited)
                    || search1(board, row, col + 1, rows, cols, str, idx + 1, visited);
            if (!found) {
                visited[row][col] = false;
            }
        }
        return found;
    }

    private void validate() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "SEE";
        System.out.println(exist(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "ABCB";
        boolean exist = exist(board, word);
        System.out.println(exist);

        board = new char[][]{
                {'a'}
        };
        word = "a";
        exist = exist(board, word);
        System.out.println(exist);
    }

    static public void main(String... args) {
        Q079WordSearch obj = new Q079WordSearch();
        obj.validate();
    }
}