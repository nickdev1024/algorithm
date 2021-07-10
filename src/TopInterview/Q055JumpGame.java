package TopInterview;

class Q055JumpGame {

    public boolean canJump(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return true;
        }
        int max = arr[0];
        int len = arr.length;
        boolean canReach = true;
        int i = 1;
        while (i < len && canReach) {
            if (i > max) {
                canReach = false;
            } else {
                max = Math.max(max, i + arr[i]);
            }
            ++i;
        }
        return canReach;
//        for (int i = 1; i < len; ++i) {
//            if (i > max) {
//                return false;
//            }
//            max = Math.max(max, i + arr[i]);
//        }
//        return true;
    }

    public boolean canJump1(int[] arr) {
        int len = arr.length;
        int lastIdx = len - 1;
        return jump(arr, 0, lastIdx);
    }

    private boolean jump(int[] arr, int idx, int dest) {
        int len = arr.length;
        if (idx >= len) {
            return false;
        }

        if (idx == dest) {
            return true;
        } else {
            int max = arr[idx];
            boolean yes = false;
            int i = max;
            while (i > 0 && !yes) {
                yes = jump(arr, idx + i--, dest);
            }
            return yes;
        }
    }

    private void validate() {
        int[][] data = {
                {2, 3, 1, 1, 4},
                {3, 2, 1, 0, 4},
                {2, 0},
                {2, 0, 0}
        };
        for (int[] num : data) {
            System.out.println(canJump(num));
        }
    }

    static public void main(String... args) {
        Q055JumpGame obj = new Q055JumpGame();
        obj.validate();
    }
}