package TopInterview;

class Q011ContainerWithMostWater {

    int maxArea(int[] height) {
        if (null == height || height.length <= 1) {
            return 0;
        }
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0, length;
        int minHeight;
        while (left < right) {
            length = right - left;
            if (height[left] <= height[right]) {
                minHeight = height[left];
                ++left;
            } else {
                minHeight = height[right];
                --right;
            }
            max = Math.max(max, length * minHeight);
        }
        return max;
    }

    private void validate() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea(height);
        System.out.println(area);

        height = new int[]{1, 1};
        area = maxArea(height);
        System.out.println(area);

        height = new int[]{4, 3, 2, 1, 4};
        area = maxArea(height);
        System.out.println(area);

        height = new int[]{1, 2, 1};
        area = maxArea(height);
        System.out.println(area);
    }

    static public void main(String... args) {
        new Q011ContainerWithMostWater().validate();
    }
}