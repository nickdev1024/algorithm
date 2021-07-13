package TopInterview;

class Q162FindPeakElement {

    public int findPeakElement(int[] arr) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        if (arr[left] > arr[left + 1]) {
            return left;
        }
        if (arr[right] > arr[right - 1]) {
            return right;
        }
        int mid, peak = 0;
        boolean found = false;
        while (left <= right && !found) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                found = true;
                peak = mid;
            } else {
                if (arr[mid - 1] >= arr[mid]) {
                    right = mid;
                } else if (arr[mid + 1] >= arr[mid]) {
                    left = mid;
                }
            }
        }
        return peak;
    }

    private void validate() {
        int[] arr = {1, 2, 3, 1};
        System.out.println(findPeakElement(arr));

        arr = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr));

        arr = new int[]{3, 4, 3, 2, 1};
        System.out.println(findPeakElement(arr));
    }

    static public void main(String... args) {
        new Q162FindPeakElement().validate();
    }
}