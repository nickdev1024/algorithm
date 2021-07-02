package TopInterview;

class Q062UniquePaths {

    public int uniquePaths(int m, int n) {
        int x = 1;
        int y = 1;
        int[][] dp = new int[m][n];
        return walk(x, y, m, n, dp);
    }

    private int walk(int startX, int startY, int endX, int endY, int[][] dp) {
        if (startX == endX && startY == endY) {
            return 1;
        }
        int total = 0;
        if (startX + 1 <= endX) {
            if (dp[startX][startY - 1] == 0) {
                dp[startX][startY - 1] = walk(startX + 1, startY, endX, endY, dp);
            }
            total += dp[startX][startY - 1];
        }
        if (startY + 1 <= endY) {
            if (dp[startX - 1][startY] == 0) {
                dp[startX - 1][startY] = walk(startX, startY + 1, endX, endY, dp);
            }
            total += dp[startX - 1][startY];
        }
        return total;
    }

    static public void main(String... args) {
        Q062UniquePaths obj = new Q062UniquePaths();
        System.out.println(obj.uniquePaths(3, 7));
        System.out.println(obj.uniquePaths(3, 2));
        System.out.println(obj.uniquePaths(3, 3));
    }
}