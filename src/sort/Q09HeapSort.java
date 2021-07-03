package sort;

import java.util.Arrays;

class Q09HeapSort {

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed - Math.random() * seed);
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

    private void heapSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            for (int idx = len - 1 - i; idx >= 0; --idx) {
                heapify(arr, idx, len - i);
            }
            swap(arr, 0, len - 1 - i);
        }
    }

    private void heapify(int[] arr, int idx, int size) {
        int left, right, largest;
        while ((left = (idx << 1) + 1) < size) {
            largest = ((right = left + 1) < size && arr[right] > arr[left] ? right : left);
            largest = arr[idx] > arr[largest] ? idx : largest;
            if (idx == largest) {
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
        int i = 0;
        boolean valid = false;
        while (i < len && (valid = arr1[i] == arr2[i])) {
            ++i;
        }
        return valid;
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

            Arrays.sort(arr1);
            heapSort(arr2);

            if (!equal(arr1, arr2)) {
                System.err.println("test failed ...");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("test passed ... time taken: %.2f seconds%n", (end - start) / 1000f);
    }

    static public void main(String... args) {
        new Q09HeapSort().validateSort();
    }
}