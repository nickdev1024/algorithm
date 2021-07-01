package TopInterview;

class Q327CountRangeSum {

    public int countRangeSum(int[] arr, int lower, int upper) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[] sum = new int[len];
        sum[0] = arr[0];
        for (int i = 1; i < len; ++i) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int left = 0;
        int right = len - 1;
        return calc(sum, left, right, lower, upper);
    }

    private int calc(int[] arr, int left, int right, int lower, int upper) {
        if (left == right) {
            return arr[left] >= lower && arr[left] <= upper ? 1 : 0;
        }
        int mid = ((right - left) >> 1) + left;
        return calc(arr, left, mid, lower, upper) + calc(arr, mid + 1, right, lower, upper)
                + merge(arr, left, mid, right, lower, upper);
    }

    // the task is to calculate how many range sum [i .. j] is between lower and upper inclusively
    // lower <= sum[i .. j] <= upper
    // lower <= sum[j] - sum[i - 1] <= upper
    // sum[i - 1] <= sum[j] - lower && sum[i - 1] >= sum[j] - upper
    private int merge(int[] arr, int left, int mid, int right, int lower, int upper) {
        int len = right - left + 1;
        int i = 0;
        int p1 = left, p2;
        int min, max;
        int count = 0;
        int windowL = left, windowR = left;
        for (p2 = mid + 1; p2 <= right; ++p2) {
            min = arr[p2] - upper;
            max = arr[p2] - lower;
            while (windowR <= mid && arr[windowR] <= max) {
                ++windowR;
            }
            while (windowL <= mid && arr[windowL] < min) {
                ++windowL;
            }
            count += windowR - windowL;
        }
        p2 = mid + 1;
        int[] help = new int[len];
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < len; ++i) {
            arr[left + i] = help[i];
        }
        return count;
    }

    private int test(int[] arr, int lower, int upper) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int sum;
        int count = 0;
        for (int start = 0; start < len; ++start) {
            for (int end = start; end < len; ++end) {
                sum = arr[start];
                for (int i = start + 1; i <= end; ++i) {
                    sum += arr[i];
                }
                count += sum >= lower && sum <= upper ? 1 : 0;
            }
        }
        return count;
    }

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed);
        }
        return arr;
    }

    static public void main(String... args) {
        int[] arr;
        int seed = 100;
        int count1, count2;
        int lower, upper;

        Q327CountRangeSum obj = new Q327CountRangeSum();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            arr = obj.generateRandArray(seed);
            lower = (int) (Math.random() * seed + seed);
            upper = (int) (Math.random() * seed + seed * 5);

            count1 = obj.countRangeSum(arr, lower, upper);
            count2 = obj.test(arr, lower, upper);

            if (count1 != count2) {
                System.err.println("test failed ...");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("test passed ... time taken: %.2f seconds", (end - start) / 1000f);
    }
}