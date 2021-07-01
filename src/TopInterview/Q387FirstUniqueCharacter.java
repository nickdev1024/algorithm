package TopInterview;

public class Q387FirstUniqueCharacter {
    //    public int firstUniqChar(String s) {
    public int firstUniqueChar(String s) {
        int unique = -1;
        if (null == s || s.length() == 0) {
            return unique;
        }
        int size = 256;
        int[] frequency = new int[size];
        char[] str = s.toCharArray();
        int len = str.length;
        for (char ch : str) {
            ++frequency[ch];
        }
        int i = 0;
        boolean notUnique = true;
        while (i < len && notUnique) {
            if (notUnique = frequency[str[i]] != 1) {
                ++i;
            } else {
                unique = i;
            }
        }
        return unique;
    }

    static public void main(String... args) {
        String[] data = {"leetcode", "loveleetcode", "aabb"};
        Q387FirstUniqueCharacter obj = new Q387FirstUniqueCharacter();
        for (String str : data) {
            System.out.println(obj.firstUniqueChar(str));
        }
    }
}