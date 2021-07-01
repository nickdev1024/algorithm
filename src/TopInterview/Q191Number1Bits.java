package TopInterview;

class Q191Number1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int num) {
        int bits = 0;
        int len = 32;
        for (int i = 0; i < len; ++i) {
            bits += (num >> i & 1) == 1 ? 1 : 0;
        }
        return bits;
    }

    static public void main(String... args) {
        int num = 00000000000000000000000000001011;
        Q191Number1Bits obj = new Q191Number1Bits();
        System.out.println(obj.hammingWeight(num));

        num = 00000000000000000000000010000000;
        System.out.println(obj.hammingWeight(num));
    }
}