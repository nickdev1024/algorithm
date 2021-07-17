package dp;

class Q03Knapsack {

    private int calcMaxValue1(int[] weight, int[] value, int bag) {
        if (null == weight || null == value || weight.length != value.length || weight.length == 0) {
            return 0;
        }
        return calc1(weight, value, 0, bag);
    }

    private int calc1(int[] weight, int[] value, int idx, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (idx == weight.length) {
            return 0;
        }
        int p1 = calc1(weight, value, idx + 1, rest);
        int p2 = 0;
        int next = calc1(weight, value, idx + 1, rest - weight[idx]);
        if (next != -1) {
            p2 = value[idx] + next;
        }
        return Math.max(p1, p2);
    }

    private int calcMaxValue2(int[] weight, int[] value, int bag) {
        if (null == weight || null == value || weight.length != value.length || weight.length == 0) {
            return 0;
        }
        // idx range from 0 - len
        // rest range from negative - bag
        int len = weight.length;
        int[][] dp = new int[len + 1][bag + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < bag + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return calc2(weight, value, 0, bag, dp);
    }

    private int calc2(int[] weight, int[] value, int idx, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (idx == weight.length) {
            return 0;
        }
        if (dp[idx][rest] != -1) {
            return dp[idx][rest];
        }
        int p1 = calc2(weight, value, idx + 1, rest, dp);
        int p2 = 0;
        int next = calc2(weight, value, idx + 1, rest - weight[idx], dp);
        if (next != -1) {
            p2 = value[idx] + next;
        }
        dp[idx][rest] = Math.max(p1, p2);
        return dp[idx][rest];
    }

    private int calcMaxValue3(int[] weight, int[] value, int bag) {
        if (null == weight || null == value || weight.length != value.length || weight.length == 0) {
            return 0;
        }
        // idx range from 0 - len
        // rest range from negative - bag
        int len = weight.length;
        int[][] dp = new int[len + 1][bag + 1];
        int p1, p2, next;
        for (int i = len - 1; i >= 0; --i) {
            for (int j = 0; j <= bag; ++j) {
                p1 = dp[i + 1][j];
                p2 = 0;
                next = j - weight[i] < 0 ? -1 : dp[i + 1][j - weight[i]];
                if (next != -1) {
                    p2 = value[i] + next;
                }
                dp[i][j] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    private void validate() {
        int[] weight = {12, 23, 34, 23, 43, 1};
        int[] value = {212, 283, 334, 3, 43, 99};
        int bag = 80;

        int max1 = calcMaxValue1(weight, value, bag);
        int max2 = calcMaxValue2(weight, value, bag);
        int max3 = calcMaxValue3(weight, value, bag);
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
    }

    static public void main(String... args) {
        new Q03Knapsack().validate();
    }
}