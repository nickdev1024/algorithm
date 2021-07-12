package TopInterview;

class Q076MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] str = s.toCharArray();
        char[] target = t.toCharArray();
        final int size = 256;
        int[] map = new int[size];
        int match = target.length;
        for (char ch : target) {
            ++map[ch];
        }

        int min = -1;
        int minLeft = -1;
        int minRight = -1;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (--map[str[right]] >= 0) {
                --match;
            }
            if (match == 0) {
                while (map[str[left]] < 0) {
                    ++map[str[left++]];
                }
                if (min == -1 || min > right - left + 1) {
                    min = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                ++match;
                ++map[str[left++]];
            }
            ++right;
        }
        return min == -1 ? "" : s.substring(minLeft, minRight + 1);
    }

    private void validate() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String str = minWindow(s, t);
        System.out.println(str);

        s = "a";
        t = "a";
        str = minWindow(s, t);
        System.out.println(str);

        s = "a";
        t = "aa";
        str = minWindow(s, t);
        System.out.println(str);

        s = "adobecodebancbbcaa";
        t = "abc";
        str = minWindow(s, t);
        System.out.println(str);
    }

    static public void main(String... args) {
        new Q076MinimumWindowSubstring().validate();
    }
}