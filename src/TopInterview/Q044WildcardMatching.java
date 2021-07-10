package TopInterview;

class Q044WildcardMatching {

    public boolean isMatch(String str, String pattern) {
        if (str == null && null == pattern) {
            return true;
        }
        if (null == str ^ null == pattern || pattern.isEmpty() ^ str.isEmpty()) {
            return false;
        }
        if (pattern.isEmpty()) {
            return true;
        }
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        return match(s, p, 0, 0);
    }

    private boolean match(char[] s, char[] p, int i, int j) {
        int len = s.length;
        char asterisk = '*';
        char question = '?';
        if (i == len) {
            if (j == p.length) {
                return true;
            } else {
                return p[j] == asterisk && match(s, p, i, j + 1);
            }
        }
        if (j == p.length) {
            return false;
        }
        if (p[j] != asterisk && p[j] != question) {
            return s[i] == p[j] && match(s, p, i + 1, j + 1);
        }
        if (p[j] == question) {
            return match(s, p, i + 1, j + 1);
        }

        for (int idx = 0; idx <= len - i; ++idx) {
            if (match(s, p, i + idx, j + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch1(String str, String pattern) {
        if (str == null && null == pattern) {
            return true;
        }
        if (null == str ^ null == pattern) {
            return false;
        }
        if (!str.isEmpty() && pattern.isEmpty()) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int rows = s.length;
        int cols = p.length;
        boolean[][] dp = new boolean[rows + 1][cols + 1];
        char asterisk = '*';
        char question = '?';
        dp[rows][cols] = true;

        for (int col = cols - 1; col >= 0; --col) {
            dp[rows][col] = p[col] == asterisk && dp[rows][col + 1];
        }
        for (int row = rows - 1; row >= 0; --row) {
            for (int col = cols - 1; col >= 0; --col) {
                if (p[col] != asterisk && p[col] != question) {
                    dp[row][col] = s[row] == p[col] && dp[row + 1][col + 1];
                } else if (p[col] == question) {
                    dp[row][col] = dp[row + 1][col + 1];
                } else {
                    dp[row][col] = dp[row + 1][col] || dp[row][col + 1];
//                    for (int idx = 0; idx <= rows - row; ++idx) {
//                        if (dp[row + idx][col + 1]) {
//                            dp[row][col] = true;
//                            break;
//                        }
//                    }
                }
            }
        }
        return dp[0][0];
    }

    private void validate() {
        String[] strings = {"aa", "aa", "cb", "adceb", "acdcb"};
        String[] patterns = {"a", "*", "?a", "*a*b", "a*c?b"};

        int len = strings.length;
        for (int i = 0; i < len; i++) {
            System.out.println(isMatch(strings[i], patterns[i]));
            System.out.println(isMatch1(strings[i], patterns[i]));
        }
    }

    static public void main(String... args) {
        new Q044WildcardMatching().validate();
    }
}