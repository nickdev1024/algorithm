package TopInterview;

class Q026RemoveDuplicatesSorted {

    private int removeDuplicates(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int k = 1;
        if (len == 1) {
            return k;
        }
        int i = 1;
        while (i < len && arr[i] >= arr[i - 1]) {
            if (arr[i] != arr[i - 1]) {
                arr[k++] = arr[i];
            }
            ++i;
        }
        return k;
    }

    static public void main(String... args) {
        int[][] data = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        };
        Q026RemoveDuplicatesSorted obj = new Q026RemoveDuplicatesSorted();
        for (int[] arr : data) {
            System.out.println("k = " + obj.removeDuplicates(arr));
        }
        System.out.println("done");
    }
}