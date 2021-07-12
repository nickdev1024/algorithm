package TopInterview;

class Q091DecodeWays {

    public int numDecoding1(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        char[] str = s.toCharArray();
        if (str[0] == '0') {
            return 0;
        }
        return decode(str, 0);
    }

    private int decode(char[] str, int idx) {
        if (idx == str.length) {
            return 1;
        }
        if (str[idx] == '0') {
            return 0;
        }
        int ways = decode(str, idx + 1);
        if (idx + 1 == str.length) {
            return ways;
        }
        int num = (str[idx] - '0') * 10 + (str[idx + 1] - '0');
        if (num <= 26) {
            ways += decode(str, idx + 2);
        }
        return ways;
    }

    public int numDecoding(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        char[] str = s.toCharArray();
        if (str[0] == '0') {
            return 0;
        }
        int len = str.length;
        int num;
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; --i) {
            if (str[i] != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 < str.length) {
                    num = (str[i] - '0') * 10 + (str[i + 1] - '0');
                    if (num <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }
        return dp[0];
    }

    private void validate() {
        String[] s = {"12", "226", "0", "06"};
        for (String str : s) {
            System.out.println(numDecoding(str));
        }
    }

    static public void main(String... args) {
        new Q091DecodeWays().validate();
    }
}