package TopInterview;

class Q014LongestCommonPrefix {

    String longestCommonPrefix(String[] list) {
        String empty = "";
        if (null == list || list.length == 0) {
            return empty;
        }
        String prefix = list[0];
        int len = list.length;
        int end = prefix.length();
        int endIdx;
        int size;
        String s;
        char[] str1, str;
        str1 = prefix.toCharArray();
        for (int i = 1; i < len; ++i) {
            endIdx = 0;
            s = list[i];
            size = s.length();
            str = s.toCharArray();
            while (endIdx < end && endIdx < size && str1[endIdx] == str[endIdx]) {
                ++endIdx;
            }
            end = Math.min(end, endIdx);
        }
        System.out.println(end);
        return prefix.substring(0, end);
    }

    static public void main(String... args) {
        String[][] data = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"}
        };

        Q014LongestCommonPrefix obj = new Q014LongestCommonPrefix();

        for (String[] list : data) {
            System.out.println(obj.longestCommonPrefix(list));
        }
    }
}
