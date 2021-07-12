package TopInterview;

class Q066PlusOne {

    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        int[] out = new int[len + 1];
        int increment = 0;
        int value;
        int base = 10;
        for (int i = len - 1; i >= 0; --i) {
            value = increment + digits[i];
            if (i == len - 1) {
                value += 1;
            }
            out[i] = value % base;
            increment = value / base;
        }
        if (increment == 1) {
            out[0] = 1;
            return out;
        }
        System.arraycopy(out, 0, digits, 0, len);
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        int[] out = new int[len + 1];
        int increment = 0;
        int value;
        int base = 10;
        for (int i = len - 1; i >= 0; --i) {
            value = increment + digits[i];
            if (i == len - 1) {
                value += 1;
            }
            out[i + 1] = value % base;
            increment = value / base;
        }
        if (increment == 1) {
            out[0] = 1;
            return out;
        }
        System.arraycopy(out, 1, digits, 0, len);
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        boolean done = false;
        while (i >= 0 && !done) {
            if (digits[i] < 9) {
                ++digits[i];
                done = true;
            } else {
                digits[i--] = 0;
            }
        }
        if (done) {
            return digits;
        }
        int[] out = new int[len + 1];
        out[0] = 1;
        return out;
    }

    private void printArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        System.out.print(arr[0]);
        String empty = " ";
        for (int i = 1; i < len; ++i) {
            System.out.print(empty + arr[i]);
        }
        System.out.println();
    }

    private void validate() {
        int[][] data = {
                {1, 2, 3},
                {4, 3, 2, 1},
                {9, 9, 9, 9},
                {0}
        };
        for (int[] num : data) {
            printArray(plusOne(num));
        }
    }

    static public void main(String... args) {
        Q066PlusOne obj = new Q066PlusOne();
        obj.validate();
    }
}