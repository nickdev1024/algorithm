package TopInterview;

class Q038CountSay {

    private String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        if (n == 1) {
            return "1";
        }
        String s;
        if ((s = countAndSay(n - 1)) != null) {
            int len = s.length();
            char[] str = s.toCharArray();
            StringBuilder res = new StringBuilder();
            int count;
            int i = 0;
            int j;
            while (i < len) {
                j = i + 1;
                count = 1;
                while (j < len && str[j] == str[i]) {
                    ++count;
                    ++j;
                }
                res.append(count).append(str[i]);
                i += count;
            }
            return res.toString();
        }
        return null;
    }

    static public void main(String... args) {
        Q038CountSay obj = new Q038CountSay();
        System.out.println(obj.countAndSay(2));
        System.out.println(obj.countAndSay(3));
        System.out.println(obj.countAndSay(4));
    }
}