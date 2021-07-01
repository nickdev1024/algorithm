package TopInterview;

class Q242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (null == s || null == t) {
            return false;
        }
        // at this point, both are not null
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int size = 256;
        int[] map = new int[size];

        char[] str = s.toCharArray();
        for (char ch : str) {
            ++map[ch];
        }
        str = t.toCharArray();
        for (char ch : str) {
            if (map[ch] == 0) {
                return false;
            }
            --map[ch];
        }
        return true;
    }

    static public void main(String... args) {
        String s = "anagram";
        String t = "nagaram";
        Q242ValidAnagram obj = new Q242ValidAnagram();
        System.out.println(obj.isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(obj.isAnagram(s, t));
    }
}
