package TopInterview;

class Q088MergeSortedArray {
    private void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = arr1.length;
        while (m > 0 && n > 0) {
            arr1[--i] = arr1[m - 1] >= arr2[n - 1] ? arr1[--m] : arr2[--n];
        }
        while (m > 0) {
            arr1[--i] = arr1[--m];
        }
        while (n > 0) {
            arr1[--i] = arr2[--n];
        }
    }

    private void printArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        System.out.print(arr[0]);
        int len = arr.length;
        String space = " ";
        for (int i = 1; i < len; ++i) {
            System.out.print(space + arr[i]);
        }
        System.out.println();
    }

    static public void main(String... args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        int m = 3, n = 3;
        Q088MergeSortedArray obj = new Q088MergeSortedArray();
        obj.merge(arr1, m, arr2, n);
        obj.printArray(arr1);

        arr1 = new int[]{1};
        m = 1;
        arr2 = new int[]{};
        n = 0;
        obj.merge(arr1, m, arr2, n);
        obj.printArray(arr1);

        arr1 = new int[]{0};
        m = 0;
        arr2 = new int[]{1};
        n = 1;
        obj.merge(arr1, m, arr2, n);
        obj.printArray(arr1);

        arr1 = new int[]{4, 5, 6, 0, 0, 0};
        m = 3;
        arr2 = new int[]{1, 2, 3};
        n = 3;
        obj.merge(arr1, m, arr2, n);
        obj.printArray(arr1);
    }
}