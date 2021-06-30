package TopInterview;

class Q028ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle || needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int len = haystack.length();
        int size = needle.length();
        int i = 0, j;
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        boolean equal = false;
        while (i < len) {
            j = 0;
            if (str1[i] == str2[j]) {
                equal = len - i >= size;
                while (++j < size && equal) {
                    equal = str1[i + j] == str2[j];
                }
                if (j == size && equal) {
                    return i;
                }
            }
            ++i;
        }
        return -1;
    }

    static public void main(String... args) {
        String[] haystacks = {"hello", "aaaaa", ""};
        String[] needles = {"ll", "bba", ""};

        Q028ImplementStrStr obj = new Q028ImplementStrStr();
        int len = haystacks.length;
        for (int i = 0; i < len; i++) {
            System.out.println(obj.strStr(haystacks[i], needles[i]));
        }
    }
}