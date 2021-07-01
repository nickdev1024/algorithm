package TopInterview;

class Q268MissingNumber {

    public int missingNumber(int[] arr) {
        int len = arr.length;
        int sum = arr[0] ^ len;

        for (int i = 1; i < len; ++i) {
            sum ^= i;
            sum ^= arr[i];
        }
        return sum;
    }

    static public void main(String... args) {
        int[][] data = {
                {3, 0, 1},
                {0, 1},
                {9, 6, 4, 2, 3, 5, 7, 0, 1},
                {0},
        };
        Q268MissingNumber obj = new Q268MissingNumber();
        for (int[] arr : data) {
            System.out.println(obj.missingNumber(arr));
        }
    }
}