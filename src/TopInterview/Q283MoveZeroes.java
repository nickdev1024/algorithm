package TopInterview;

class Q283MoveZeroes {

    public void moveZeroes(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int nonZero = left - 1;
        while (left <= right) {
            if (arr[left] != 0) {
                swap(arr, left, ++nonZero);
            }
            ++left;
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
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
        int[][] data = {
                {0, 1, 0, 3, 12},
                {0}
        };
        Q283MoveZeroes obj = new Q283MoveZeroes();
        for (int[] arr : data) {
            obj.moveZeroes(arr);
            obj.printArray(arr);
        }
    }
}