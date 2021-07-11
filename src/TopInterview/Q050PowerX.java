package TopInterview;

class Q050PowerX {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 == Math.abs(x) ? 1 : 0;
        }
        int power = n;
        if (n >>> 31 == 1) {
            power = -power;
        }
        double value = x;
        double res = 1;
        while (power != 0) {
            if ((power & 1) != 0) {
                res *= value;
            }
            power >>= 1;
            value *= value;
        }
        return (n >>> 31) == 1 ? 1D / res : res;
    }

    private void validate() {
        double x = 2.00000;
        int n = 10;
        double res = myPow(x, n);
        System.out.printf("%.5f%n", res);

        x = 2.10000;
        n = 3;
        res = myPow(x, n);
        System.out.printf("%.5f%n", res);

        x = 2.00000;
        n = -2;
        res = myPow(x, n);
        System.out.printf("%.5f%n", res);
    }

    static public void main(String... args) {
        new Q050PowerX().validate();
    }
}