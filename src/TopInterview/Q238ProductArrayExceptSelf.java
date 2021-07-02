package TopInterview;

class Q238ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] arr) {
        int product = 1;
        int zeros = 0;
        for (int num : arr) {
            if (num != 0) {
                product *= num;
            } else {
                ++zeros;
            }
        }
        int len = arr.length;
        if (zeros > 1) {
            for (int i = 0; i < len; i++) {
                arr[i] = 0;
            }
        } else {
            if (zeros == 0) {
                for (int i = 0; i < len; i++) {
                    arr[i] = product / arr[i];
                }
            } else {
                for (int i = 0; i < len; i++) {
                    arr[i] = arr[i] == 0 ? product : 0;
                }
            }
        }
        return arr;
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
                {1, 2, 3, 4},
                {-1, 1, 0, -3, 3},
                {0, 0},
                {0, 4, 0}
        };
        Q238ProductArrayExceptSelf obj = new Q238ProductArrayExceptSelf();
        int[] ans;
        for (int[] num : data) {
            ans = obj.productExceptSelf(num);
            obj.printArray(ans);
        }
    }
}