package TopInterview;

class Q042TrappingRainWater {

    public int trap(int[] height) {
        int min = 3;
        if (null == height || height.length < min) {
            return 0;
        }
        int len = height.length;
        int left = 1;
        int right = len - 2;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int water = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                water += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return water;
    }

    private int test(int[] height) {
        int min = 3;
        if (null == height || height.length < min) {
            return 0;
        }
        int len = height.length;
        int lastIdx = len - 1;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[lastIdx] = height[lastIdx];
        for (int i = 1; i < lastIdx; ++i) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[lastIdx - i] = Math.max(height[lastIdx - i], rightMax[lastIdx - i + 1]);
        }
        int water = 0;
        int i = 1;
        while (i < lastIdx) {
            if (leftMax[i - 1] <= rightMax[i + 1]) {
                water += Math.max(0, leftMax[i - 1] - height[i]);
            } else {
                water += Math.max(0, rightMax[i + 1] - height[i]);
            }
            ++i;
        }
        return water;
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
        int[][] heights = {
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {4, 2, 0, 3, 2, 5}
        };
        for (int[] height : heights) {
            System.out.println(trap(height));
            System.out.println(test(height));
        }

        int[] height;
        int water1, water2;
        int seed = 100;
        int million = 1_000_000;
        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            height = generateRandArray(seed);

            water1 = trap(height);
            water2 = test(height);

            if (water1 != water2) {
                System.err.println("test failed ...");
                return;
            }
        }
        System.out.println("test passed ...");
    }

    static public void main(String... args) {
        new Q042TrappingRainWater().validate();
    }
}