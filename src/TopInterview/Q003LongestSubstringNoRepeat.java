package TopInterview;

class Q003LongestSubstringNoRepeat {

    private int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        // ascii table has 256 characters, use this map to mark the last appeared position
        final int size = 256;
        int[] map = new int[size];
        for (int i = 0; i < size; i++) {
            map[i] = -1;
        }
        // this is the last index with no repeat character
        int prevIdx = -1;
        int max = 0;
        int len;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            prevIdx = Math.max(prevIdx, map[str[i]]);
            len = i - prevIdx;
            max = Math.max(max, len);
            map[str[i]] = i;
        }
        return max;
    }

    static public void main(String... args) {
        Q003LongestSubstringNoRepeat obj = new Q003LongestSubstringNoRepeat();
        String[] data = {"abcabcbb", "bbbb", "pwwkew", ""};
        for (String str : data) {
            System.out.println(obj.lengthOfLongestSubstring(str));
        }
    }
}
