package TopInterview;

class Q171ExcelSheetColumnNumber {

    public int test(String columnTitle) {
        char[] cols = columnTitle.toCharArray();
        int ans = 0;
        int multiply = 26;
        int val;
        int len = cols.length;
        int size = len - 1;
        char col;
        for (int i = size; i >= 0; --i) {
            col = cols[i];
            val = (int) Math.pow(multiply, size - i);
            ans += (col - '@') * val;
        }
        return ans;
    }

    public int titleToNumber(String columnTitle) {
        char[] cols = columnTitle.toCharArray();
        int ans = 0;
        int base = 26;
        for (char col : cols) {
            ans = ans * base + col - '@';
        }
        return ans;
    }

    static public void main(String... args) {
        Q171ExcelSheetColumnNumber obj = new Q171ExcelSheetColumnNumber();
        String[] data = {"A", "AB", "ZY", "FXSHRXW"};
        for (String column : data) {
            System.out.println(obj.titleToNumber(column));
        }
    }
}