package TopInterview;

class Q069SqrtX {

    public int mySqrt(int num) {
        if (num == 0) {
            return num;
        }
        if (num <= 3) {
            return 1;
        }
        long left = 1;
        long right = num;
        long mid, sqrt = 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (mid * mid <= num) {
                sqrt = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) sqrt;
    }

    private void validate() {
        int[] data = {4, 8};
        for (int num : data) {
            System.out.println(mySqrt(num));
        }
        int range = 1_000_000;
        int sqrt1, sqrt2;
        System.out.println("test started ...");
        for (int num = 0; num <= range; num++) {
            sqrt1 = mySqrt(num);
            sqrt2 = (int) Math.sqrt(num);
            if (sqrt1 != sqrt2) {
                System.err.println("sqrt1: " + sqrt1 + ", sqrt2: " + sqrt2);
                System.err.println("test failed ... " + num);
                return;
            }
        }
        System.out.println("test passed ...");
    }

    static public void main(String... args) {
        new Q069SqrtX().validate();
    }
}