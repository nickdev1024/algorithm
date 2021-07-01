package TopInterview;

class Q125ValidPalindrome {

    private boolean isPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        char[] str = s.toCharArray();
        int len = str.length;
        int left = 0, right = len - 1;
        boolean isNum = false;
        int diff = 'a' - 'A';
        while (left < right) {
            if (!isAlpha(str[left]) && !(isNum = isNum(str[left]))) {
                ++left;
                continue;
            }
            if (!isAlpha(str[right]) && !(isNum = isNum(str[right]))) {
                --right;
                continue;
            }
            if (str[left] != str[right]) {
                if (isNum) {
                    return false;
                } else if (Math.abs(str[left] - str[right]) != diff) {
                    return false;
                }
            }
            --right;
            ++left;
        }
        return true;
    }

    private boolean isAlpha(char ch) {
        char upperA = 'A';
        char lowerA = 'a';
        char upperZ = 'Z';
        char lowerZ = 'z';
        return ch >= upperA && ch <= upperZ
                || ch >= lowerA && ch <= lowerZ;
    }

    private boolean isNum(char ch) {
        char char0 = '0';
        char char9 = '9';
        return ch >= char0 && ch <= char9;
    }

    static public void main(String... args) {
        Q125ValidPalindrome obj = new Q125ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(s));
        s = "race a car";
        System.out.println(obj.isPalindrome(s));
        s = "0P";
        boolean valid = obj.isPalindrome(s);
        System.out.println(valid);
    }
}