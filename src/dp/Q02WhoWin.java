package dp;

class Q02WhoWin {

    private int win1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int first = first1(arr, left, right);
        int second = second1(arr, left, right);
        return Math.max(first, second);
    }

    private int first1(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int p1 = arr[left] + second1(arr, left + 1, right);
        int p2 = arr[right] + second1(arr, left, right - 1);
        return Math.max(p1, p2);
    }

    private int second1(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int p1 = first1(arr, left + 1, right);
        int p2 = first1(arr, left, right - 1);
        return Math.min(p1, p2);
    }

    private int win2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[][] fDp = new int[len][len];
        int[][] sDp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                fDp[i][j] = -1;
                sDp[i][j] = -1;
            }
        }
        int left = 0;
        int right = len - 1;
        int first = first2(arr, left, right, fDp, sDp);
        int second = second2(arr, left, right, fDp, sDp);
        return Math.max(first, second);
    }

    private int first2(int[] arr, int left, int right, int[][] fDp, int[][] sDp) {
        if (fDp[left][right] != -1) {
            return fDp[left][right];
        }
        int ans;
        if (left == right) {
            ans = arr[left];
        } else {
            int p1 = arr[left] + second2(arr, left + 1, right, fDp, sDp);
            int p2 = arr[right] + second2(arr, left, right - 1, fDp, sDp);
            ans = Math.max(p1, p2);
        }
        fDp[left][right] = ans;
        return ans;
    }

    private int second2(int[] arr, int left, int right, int[][] fDp, int[][] sDp) {
        if (sDp[left][right] != -1) {
            return sDp[left][right];
        }
        int ans = 0;
        if (left != right) {
            int p1 = first2(arr, left + 1, right, fDp, sDp);
            int p2 = first2(arr, left, right - 1, fDp, sDp);
            ans = Math.min(p1, p2);
        }
        sDp[left][right] = ans;
        return ans;
    }

    private int win3(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[][] fDp = new int[len][len];
        int[][] sDp = new int[len][len];
        for (int i = 0; i < len; i++) {
            fDp[i][i] = arr[i];
        }
        int col = 1;
        int p1, p2;
        int left, right;
        while (col < len) {
            left = 0;
            right = col;
            while (right < len) {
                p1 = arr[left] + sDp[left + 1][right];
                p2 = arr[right] + sDp[left][right - 1];
                fDp[left][right] = Math.max(p1, p2);
                p1 = fDp[left + 1][right];
                p2 = fDp[left][right - 1];
                sDp[left][right] = Math.min(p1, p2);
                ++left;
                ++right;
            }
            ++col;
        }
        return Math.max(fDp[0][len - 1], sDp[0][len - 1]);
    }

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed - Math.random() * seed);
        }
        return arr;
    }

    private void validate() {
        int seed = 20;
        int[] arr;
        arr = generateRandArray(seed);
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }

    static public void main(String... args) {
        new Q02WhoWin().validate();
    }
}