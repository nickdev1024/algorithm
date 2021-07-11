package TopInterview;

class Q053MaximumSubArray {

    private int maxSubArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int val : arr) {
            sum += val;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    private int maxSubArray1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int sum = arr[0];
        int max = sum;

        for (int i = 1; i < len; ++i) {
            sum = Math.max(sum, 0);
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed - Math.random() * seed);
        }
        return arr;
    }

    private void validate() {
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr;
        int seed = 100;
        int max1, max2;

        int million = 1_000_000;
        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            arr = generateRandArray(seed);
            max1 = maxSubArray(arr);
            max2 = maxSubArray1(arr);

            if (max1 != max2) {
                System.err.println("test failed ...");
                return;
            }
        }
        System.out.println("test passed ...");
    }

    static public void main(String... args) {
        Q053MaximumSubArray obj = new Q053MaximumSubArray();
        obj.validate();
    }
}