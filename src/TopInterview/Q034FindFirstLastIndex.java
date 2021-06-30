package TopInterview;

class Q034FindFirstLastIndex {

    private int[] searchRange(int[] arr, int target) {
        int[] ans = {-1, -1};
        if (null == arr || arr.length == 0) {
            return ans;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int idx = locate(arr, target);
        if (idx == -1) {
            return ans;
        }
        int leftIdx = getLeftIdx(arr, left, idx, target);
        int rightIdx = getRightIdx(arr, idx, right, target);
        return new int[]{leftIdx, rightIdx};
    }

    private int getLeftIdx(int[] arr, int left, int right, int target) {
        int mid;
        int value;
        int idx = -1;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            value = arr[mid];
            if (value >= target) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    private int getRightIdx(int[] arr, int left, int right, int target) {
        int mid;
        int value;
        int idx = -1;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            value = arr[mid];
            if (value <= target) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }

    private int locate(int[] arr, int target) {
        int idx = -1;
        if (null == arr || arr.length == 0) {
            return idx;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int mid;
        int value;
        boolean found = false;
        while (left <= right && !found) {
            mid = ((right - left) >> 1) + left;
            value = arr[mid];
            if (value == target) {
                idx = mid;
                found = true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }

    private void printArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        System.out.print(arr[0]);

        for (int i = 1; i < len; ++i) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    static public void main(String... args) {
        int[][] arr = {
                {5, 7, 7, 8, 8, 10},
                {5, 7, 7, 8, 8, 10},
                {}
        };
        int[] targets = {8, 6, 0};
        Q034FindFirstLastIndex obj = new Q034FindFirstLastIndex();
        int len = targets.length;
        for (int i = 0; i < len; i++) {
            obj.printArray(obj.searchRange(arr[i], targets[i]));
        }
    }
}