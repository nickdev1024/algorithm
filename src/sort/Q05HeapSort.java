package sort;

import java.util.Arrays;

class Q05HeapSort {

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

    private int[] heapSort(int[] arr) {
        if (null == arr) {
            return null;
        }
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int[] sorted = new int[len];
        for (int i = 0; i < len; ++i) {
            for (int idx = len - i - 1; idx >= 0; --idx) {
                heapify(arr, idx, len - i);
            }
            sorted[i] = arr[0];
            swap(arr, 0, len - 1 - i);
        }
        return sorted;
    }

    private void heapify(int[] arr, int idx, int size) {
        int left, right, smallest;
        while ((left = (idx << 1) + 1) < size) {
            smallest = (right = left + 1) < size && arr[right] <= arr[left] ? right : left;
            if (arr[idx] <= arr[smallest]) {
                break;
            }
            swap(arr, idx, smallest);
            idx = smallest;
        }
    }

    private int[] heapSort1(int[] arr) {
        if (null == arr) {
            return null;
        }
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            for (int idx = 1; idx < len - i; ++idx) {
                heapInsert(arr, idx);
            }
            sorted[i] = arr[0];
            swap(arr, 0, len - 1 - i);
        }
        return sorted;
    }

    private void heapInsert(int[] arr, int idx) {
        int root;
        while ((root = ((idx - 1) >> 1)) >= 0) {
            if (arr[root] > arr[idx]) {
                swap(arr, root, idx);
                idx = root;
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

    private void printArray(int[] arr) {
        if (null == arr || arr.length <= 0) {
            return;
        }
        int len = arr.length;
        String space = " ";
        System.out.print(arr[0]);
        for (int i = 1; i < len; i++) {
            System.out.print(space + arr[i]);
        }
        System.out.println();
    }

    static public void main(String... args) {
        int[] arr1, arr2;
        int seed = 100;
        Q05HeapSort obj = new Q05HeapSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

//            arr1 = obj.heapSort(arr1);
            arr1 = obj.heapSort1(arr1);
            Arrays.sort(arr2);

            if (!obj.equal(arr1, arr2)) {
                obj.printArray(arr1);
                obj.printArray(arr2);
                System.err.println("test fail ...");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("test passed ... time taken %.2f seconds%n", (end - start) / 1000f);
    }
}