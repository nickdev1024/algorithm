package TopInterview;

class Q070ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int three = 3;
        for (int i = 0; i < three && i <= n; ++i) {
            dp[i] = i;
        }
        if (n < three) {
            return dp[n];
        }
        return calc(n, dp);
    }

    private int calc(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (dp[n - 1] == 0) {
            calc(n - 1, dp);
        }
        dp[n] = dp[n - 1] + dp[n - 2];
        return dp[n];
    }

    private void validate() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(climbStairs(i));
        }
    }

    static public void main(String... args) {
        Q070ClimbingStairs obj = new Q070ClimbingStairs();
        obj.validate();
    }
}