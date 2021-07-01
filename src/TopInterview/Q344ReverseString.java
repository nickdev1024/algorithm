package TopInterview;

class Q344ReverseString {

    public void reverseString(char[] str) {
        if (null == str || str.length <= 1) {
            return;
        }
        int len = str.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            swap(str, left++, right--);
        }
    }

    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
        }
    }

    private void printStr(char[] str) {
        if (null == str || str.length == 0) {
            return;
        }
        String single = "'";
        System.out.print(single + str[0] + single);
        int len = str.length;
        String space = " ";
        for (int i = 1; i < len; ++i) {
            System.out.print(space + single + str[i] + single);
        }
        System.out.println();
    }

    static public void main(String... args) {
        char[][] data = {
                {'h', 'e', 'l', 'l', 'o'},
                {'H', 'a', 'n', 'n', 'a', 'h'}
        };
        Q344ReverseString obj = new Q344ReverseString();
        for (char[] str : data) {
            obj.reverseString(str);
            obj.printStr(str);
        }
    }
}