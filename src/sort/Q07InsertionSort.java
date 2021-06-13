package sort;

import java.util.Arrays;

class Q07InsertionSort {

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

    private void insertSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int prevIdx, idx;
        for (int i = 1; i < len; ++i) {
            idx = i;
            prevIdx = idx - 1;
            while (prevIdx >= 0 && arr[prevIdx] > arr[idx]) {
                swap(arr, prevIdx, idx);
                idx = prevIdx--;
            }
        }
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
        boolean equal = true;
        while (i < len && (equal = arr1[i] == arr2[i])) {
            ++i;
        }
        return equal;
    }

    static public void main(String... args) {
        int[] arr1, arr2;
        int seed = 100;
        Q07InsertionSort obj = new Q07InsertionSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.insertSort(arr1);
            Arrays.sort(arr2);

            if (!obj.equal(arr1, arr2)) {
                System.err.println("test fail ...");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("test passed ... time taken %.2f seconds%n", (end - start) / 1000f);
    }
}