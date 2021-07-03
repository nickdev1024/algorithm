package TopInterview;

class Q079WordSearch {

    public boolean exist(char[][] board, String word) {
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
                found = search(board, row, col, rows, cols, str, idx, visited);
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

    private boolean search(char[][] board, int row, int col, int rows, int cols, char[] str, int idx, boolean[][] visited) {
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
            found = search(board, row - 1, col, rows, cols, str, idx + 1, visited)
                    || search(board, row + 1, col, rows, cols, str, idx + 1, visited)
                    || search(board, row, col - 1, rows, cols, str, idx + 1, visited)
                    || search(board, row, col + 1, rows, cols, str, idx + 1, visited);
            if (!found) {
                visited[row][col] = false;
            }
        }
        return found;
    }

    static public void main(String... args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        Q079WordSearch obj = new Q079WordSearch();
        System.out.println(obj.exist(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        word = "SEE";
        System.out.println(obj.exist(board, word));

        board = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        word = "ABCB";
        boolean exist = obj.exist(board, word);
        System.out.println(exist);

        board = new char[][]{
                {'a'}
        };
        word = "a";
        exist = obj.exist(board, word);
        System.out.println(exist);
    }
}