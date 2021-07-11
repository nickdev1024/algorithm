package TopInterview;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 */
class Q1306JumpGameIII {

    public boolean canReach(int[] arr, int idx) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int len = arr.length;
        if (len == 1 && arr[0] != 0) {
            return false;
        }
        if (idx < 0 || idx >= len) {
            return false;
        }
        if (arr[idx] == 0) {
            return true;
        }
        boolean[] visited = new boolean[len];
        visited[idx] = true;
        return jump(arr, idx, visited);
    }

    private boolean jump(int[] arr, int idx, boolean[] visited) {
        if (!visited[idx]) {
            visited[idx] = true;
            if (arr[idx] == 0) {
                return true;
            }
        }
        int len = arr.length;
        int left, right;
        left = idx - arr[idx];
        right = idx + arr[idx];
        if (left >= 0 && !visited[left]) {
            if (jump(arr, left, visited)) {
                return true;
            }
        }
        if (right < len && !visited[right]) {
            return jump(arr, right, visited);
        }
        return false;
    }

    private void validate() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(arr, start));
        start = 0;
        System.out.println(canReach(arr, start));

        arr = new int[]{4, 4, 1, 3, 0, 3};
        start = 2;
        System.out.println(canReach(arr, start));
    }

    static public void main(String... args) {
        new Q1306JumpGameIII().validate();
    }
}