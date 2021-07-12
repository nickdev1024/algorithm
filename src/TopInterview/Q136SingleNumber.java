package TopInterview;

class Q136SingleNumber {

    public int singleNumber(int[] arr) {
        if (null == arr || arr.length == 0) {
            throw new RuntimeException("invalid arr provided");
        }
        int len = arr.length;
        int num = arr[0];
        for (int i = 1; i < len; ++i) {
            num ^= arr[i];
        }
        return num;
    }

    private void validate() {
        int[] arr = {2, 2, 1};
        System.out.println(singleNumber(arr));

        arr = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));

        arr = new int[]{1};
        System.out.println(singleNumber(arr));
    }

    static public void main(String... args) {
        Q136SingleNumber obj = new Q136SingleNumber();
        obj.validate();
    }
}