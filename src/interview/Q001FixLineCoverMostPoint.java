package interview;

import java.util.Arrays;

class Q001FixLineCoverMostPoint {

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed);
        }
        return arr;
    }

    private int calcMostCover(int[] arr, int length) {
        if (null == arr || arr.length == 0 || length <= 0) {
            return 0;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int range = arr[right] - arr[left];
        if (range <= length) {
            return len;
        }
        int max = 0;
        int j;
        boolean valid = true;
        for (int i = 0; i < len; ++i) {
            j = i;
            while (j < len && (valid = arr[j] - arr[i] <= length)) {
                ++j;
            }
            max = Math.max(max, j - i + (valid ? 0 : 1));
        }
        return max;
    }

    private int coverMost(int[] arr, int length) {
        if (null == arr || arr.length == 0 || length <= 0) {
            return 0;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int range = arr[right] - arr[left];
        if (range <= length) {
            return len;
        }
        int max = 0;
        int windowR = 0;
        for (int i = 0; i < len; ++i) {
            while (windowR < len && arr[windowR] - arr[i] <= length) {
                ++windowR;
            }
            max = Math.max(max, windowR - i + (windowR >= len ? 0 : 1));
        }
        return max;
    }

    private void heapSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int i = len - 1; i >= 0; --i) {
            heapify(arr, i, len);
        }
        while (len > 1) {
            swap(arr, len - 1, 0);
            heapify(arr, 0, --len);
        }
    }

    private void heapify(int[] arr, int idx, int size) {
        int left, right, largest;
        while ((left = (idx << 1) + 1) < size) {
            largest = (right = 1 + left) < size && arr[right] > arr[left] ? right : left;
            largest = arr[idx] > arr[largest] ? idx : largest;
            if (largest == idx) {
                break;
            }
            swap(arr, idx, largest);
            idx = largest;
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    private boolean equal(int[] arr1, int[] arr2) {
        if (arr1 == arr2) {
            return true;
        }
        if (null == arr1 ^ null == arr2) {
            return false;
        }
        int len = arr1.length;
        if (len != arr2.length) {
            return false;
        }
        boolean equal = false;
        int i = 0;
        while (i < len && (equal = arr1[i] == arr2[i])) {
            ++i;
        }
        return equal;
    }

    private void printArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        System.out.print(arr[0]);

        String space = " ";
        for (int i = 1; i < len; ++i) {
            System.out.print(space + arr[i]);
        }
        System.out.println();
    }

    private int[] copyArray(int[] arr) {
        if (null == arr) {
            return null;
        }
        int len = arr.length;
        int[] copy = new int[len];
        System.arraycopy(arr, 0, copy, 0, len);
        return copy;
    }

    private boolean validateSort() {
        int[] arr1, arr2;
        int seed = 100, million = 1_000_000;

        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            arr1 = generateRandArray(seed);
            arr2 = copyArray(arr1);

            Arrays.sort(arr1);
            heapSort(arr2);

            if (!equal(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                System.err.println("test failed ...");
                return false;
            }
        }
        System.out.println("test passed ...");
        return true;
    }

    private void coverMostPoint() {
        int[] arr;
        int length, seed = 200, ten = 10;
        int max1, max2;

        int million = 1_000_000;

        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            length = (int) (Math.random() * seed + ten);
            arr = generateRandArray(seed);
            heapSort(arr);

            max1 = calcMostCover(arr, length);
            max2 = coverMost(arr, length);

            if (max1 != max2) {
                printArray(arr);
                System.out.println("length: " + length);
                System.out.println("1. " + max1 + ", 2. " + max2);
                System.err.println("test failed ...");
                return;
            }
        }
        System.out.println("test passed ...");
    }

    static public void main(String... args) {
        Q001FixLineCoverMostPoint obj = new Q001FixLineCoverMostPoint();
//        obj.validateSort();
        obj.coverMostPoint();
    }
}