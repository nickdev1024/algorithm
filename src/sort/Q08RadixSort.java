package sort;

import java.util.Arrays;

class Q08RadixSort {

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed);
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

    private int calcDigits(int num) {
        int digits = 0;
        int base = 10;
        while (num > 0) {
            num /= base;
            ++digits;
        }
        return digits;
    }

    private int calcDigitValue(int num, int digit) {
        int base = 10;
        while (digit != 0) {
            num /= base;
            --digit;
        }
        return num % base;
    }

    private void radixSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int max = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, arr[i]);
        }
        int digits = calcDigits(max);
        // each digit has 10 values: 0 1 2 3 4 5 6 7 8 9
        int size = 10;
        int[] sum = new int[size];
        int digitValue;
        int[] help = new int[len];

        for (int digit = 0; digit < digits; ++digit) {
            for (int val : arr) {
                digitValue = calcDigitValue(val, digit);
                ++sum[digitValue];
            }
            for (int i = 1; i < size; ++i) {
                sum[i] += sum[i - 1];
            }
            for (int i = len - 1; i >= 0; --i) {
                digitValue = calcDigitValue(arr[i], digit);
                help[--sum[digitValue]] = arr[i];
            }
            for (int i = 0; i < size; i++) {
                sum[i] = 0;
            }
            System.arraycopy(help, 0, arr, 0, len);
        }
    }

    static public void main(String... args) {
        int[] arr1, arr2;
        int seed = 100;
        Q08RadixSort obj = new Q08RadixSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.radixSort(arr1);
            Arrays.sort(arr2);

            if (!obj.equal(arr1, arr2)) {
                System.err.println("test failed ...");
                return;
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("test passed ... time taken : %.2f seconds%n", (end - start) / 1000f);
    }
}