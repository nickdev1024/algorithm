package sort;

import java.util.Arrays;

class Q04QuickSort {

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed + 1 - Math.random() * seed);
        }
        return arr;
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

    private void quickSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        doSort(arr, left, right);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int equal = partition(arr, left, right);
        doSort(arr, left, equal - 1);
        doSort(arr, equal + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int len = right - left + 1;
        int randIdx = left + (int) (Math.random() * len);
        swap(arr, randIdx, right);
        int pivot = arr[right];
        int lessEqual = left - 1;
        int more = right;
        int i = left;

        while (i < more) {
            if (arr[i] <= pivot) {
                swap(arr, ++lessEqual, i++);
            } else {
                swap(arr, --more, i);
            }
        }
        swap(arr, more, right);
        return more;
    }

    private void swap(int[] arr, int i, int j) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        if (i >= len || j >= len || i < 0 || j < 0 || i == j) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
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
        int i = 0;
        boolean equal = false;
        while (i < len && (equal = arr1[i] == arr2[i])) {
            ++i;
        }
        return equal;
    }

    private void printArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        String space = " ";
        int len = arr.length;
        System.out.print(arr[0]);
        for (int i = 1; i < len; ++i) {
            System.out.print(space + arr[i]);
        }
        System.out.println();
    }

    private void validateSort() {
        int[] arr1, arr2;
        int seed = 100;
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = generateRandArray(seed);
            arr2 = copyArray(arr1);

            quickSort(arr1);
            Arrays.sort(arr2);

            if (!equal(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                System.err.println("test failed ...");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("test passed ... time taken %.2f seconds%n", (end - start) / 1000f);
    }

    static public void main(String... args) {
        new Q04QuickSort().validateSort();
    }
}