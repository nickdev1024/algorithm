# Algorithm

[TOC]



## Sort Algorithm

### Bubble Sort

```java
import java.util.Arrays;

class Q01BubbleSort {

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

    private void bubbleSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int i = len - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
        Q01BubbleSort obj = new Q01BubbleSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.bubbleSort(arr1);
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
```

### Merge Sort

```java
import java.util.Arrays;

class Q02MergeSort {

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

    private void mergeSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        doSort(arr, left, right);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = ((right - left) >> 1) + left;
        doSort(arr, left, mid);
        doSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        int[] help = new int[len];
        int i = 0;
        int p1 = left, p2 = mid + 1;
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
        Q02MergeSort obj = new Q02MergeSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.mergeSort(arr1);
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
```

### Quick Sort 1

```java
import java.util.Arrays;

class Q03QuickSort {

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
        int[] equals = partition(arr, left, right);
        doSort(arr, left, equals[0] - 1);
        doSort(arr, equals[1] + 1, right);
    }

    private int[] partition(int[] arr, int left, int right) {
        int len = right - left + 1;
        int randIdx = left + (int) (Math.random() * len);
        swap(arr, randIdx, right);
        int pivot = arr[right];
        int less = left - 1;
        int more = right;

        for (int i = left; i < more; ++i) {
            if (arr[i] < pivot) {
                swap(arr, ++less, i);
            } else if (arr[i] > pivot) {
                swap(arr, --more, i--);
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
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

    static public void main(String... args) {
        int[] arr1, arr2;
        int seed = 100;
        Q03QuickSort obj = new Q03QuickSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.quickSort(arr1);
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
```

### Quick Sort 2

```java
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
        boolean equal = true;
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

    static public void main(String... args) {
        int[] arr1, arr2;
        int seed = 100;
        Q04QuickSort obj = new Q04QuickSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.quickSort(arr1);
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
```

### Heap Sort

```java
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
```

### Selection Sort

```java
import java.util.Arrays;

class Q06SelectionSort {

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

    private void selectSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int min;
        for (int i = 0; i < len - 1; ++i) {
            min = i;
            for (int j = i + 1; j < len; ++j) {
                min = arr[min] > arr[j] ? j : min;
            }
            if (min != i) {
                swap(arr, min, i);
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
        Q06SelectionSort obj = new Q06SelectionSort();
        int million = 1_000_000;

        long start = System.currentTimeMillis();
        System.out.println("test started ...");
        for (int i = 0; i < million; ++i) {
            arr1 = obj.generateRandArray(seed);
            arr2 = obj.copyArray(arr1);

            obj.selectSort(arr1);
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
```

### Insertion Sort

```java
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
```

### Radix Sort

```java
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
```

