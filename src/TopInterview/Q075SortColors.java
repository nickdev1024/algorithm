package TopInterview;

class Q075SortColors {

    public void sortColors(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        int i = 0;
        int redZone = -1;
        int blueZone = len;

        int red = 0, white = 1, blue = 2;

        while (i < len && i < blueZone) {
            if (arr[i] == red) {
                // color red
                swap(arr, i++, ++redZone);
            } else if (arr[i] == blue) {
                // color blue
                swap(arr, i, --blueZone);
            } else {
                // color white
                ++i;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
    }

    static public void main(String... args) {
        int[][] data = {
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
                {0},
                {1}
        };
        Q075SortColors obj = new Q075SortColors();
        for (int[] num : data) {
            obj.sortColors(num);
        }
    }
}