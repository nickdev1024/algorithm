package TopInterview;

class Q852PeakIndexMountainArray {

    private int test(int[] arr) {
        if (null == arr || arr.length < 3) {
            return -1;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int peak = left;
        while (left <= right) {
            if (arr[left] >= arr[right]) {
                peak = left;
                --right;
            } else {
                peak = right;
                ++left;
            }
        }
        return peak;
    }

    public int peakIndexInMountainArray(int[] arr) {
        if (null == arr || arr.length < 3) {
            return -1;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int leftP = left;
        int rightP = right;
        ++left;
        --right;
        while (left <= right) {
            if (arr[left] >= arr[leftP]) {
                leftP = left;
            }
            if (arr[right] >= arr[rightP]) {
                rightP = right;
            }
            ++left;
            --right;
        }
        return arr[leftP] >= arr[rightP] ? leftP : rightP;
    }

    private void validate() {
        int peak;
        int[] arr = {0, 1, 0};
        peak = peakIndexInMountainArray(arr);
        peak = test(arr);
        System.out.println(peak);

        arr = new int[]{0, 2, 1, 0};
        peak = peakIndexInMountainArray(arr);
        peak = test(arr);
        System.out.println(peak);

        arr = new int[]{0, 10, 5, 2};
        peak = peakIndexInMountainArray(arr);
        peak = test(arr);
        System.out.println(peak);

        arr = new int[]{3, 4, 5, 1};
        peak = peakIndexInMountainArray(arr);
        peak = test(arr);
        System.out.println(peak);

        arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        peak = peakIndexInMountainArray(arr);
        peak = test(arr);
        System.out.println(peak);
    }

    static public void main(String... args) {
        new Q852PeakIndexMountainArray().validate();
    }
}