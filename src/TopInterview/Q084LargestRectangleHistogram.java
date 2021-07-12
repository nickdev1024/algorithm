package TopInterview;

import java.util.Stack;

class Q084LargestRectangleHistogram {

    public int largestRectangleArea1(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int length, idx, left;
        int area = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                idx = stack.pop();
                left = stack.empty() ? -1 : stack.peek();
                length = i - left - 1;
                area = Math.max(area, length * heights[idx]);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            idx = stack.pop();
            left = stack.empty() ? -1 : stack.peek();
            length = len - 1 - left;
            area = Math.max(area, length * heights[idx]);
        }
        return area;
    }

    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }
        int[][] info = calcInfo(heights);
        int len = heights.length;
        int area = 0;
        int length, idx0 = 0, idx1 = 1;
        for (int i = 0; i < len; i++) {
            length = info[i][idx1] - 1 - info[i][idx0];
            area = Math.max(area, length * heights[i]);
        }
        return area;
    }

    private int[][] calcInfo(int[] heights) {
        int len = heights.length;
        int[][] info = new int[len][2];
        int idx, idx0 = 0, idx1 = 1, left;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                idx = stack.pop();
                left = !stack.empty() ? stack.peek() : -1;
                info[idx][idx0] = left;
                info[idx][idx1] = i;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            idx = stack.pop();
            left = !stack.empty() ? stack.peek() : -1;
            info[idx][idx0] = left;
            info[idx][idx1] = len;
        }
        return info;
    }

    private void validate() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int area = largestRectangleArea(heights);
        System.out.println(area);
        area = largestRectangleArea1(heights);
        System.out.println(area);

        heights = new int[]{2, 4};
        area = largestRectangleArea(heights);
        System.out.println(area);
        area = largestRectangleArea1(heights);
        System.out.println(area);
    }

    static public void main(String... args) {
        new Q084LargestRectangleHistogram().validate();
    }
}