package TopInterview;

import java.util.HashMap;
import java.util.Map;

class Q128LongestConsecutiveSequence {

    public int longestConsecutive(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int prev, next;
        int prevLength, nextLength, fullLength;
        int max = 0;
        for (int num : arr) {
            if (!start.containsKey(num) && !end.containsKey(num)) {
                start.put(num, 1);
                end.put(num, 1);
                prev = num - 1;
                next = num + 1;
                prevLength = end.getOrDefault(prev, 0);
                nextLength = start.getOrDefault(next, 0);
                fullLength = 1 + prevLength + nextLength;
                max = Math.max(max, fullLength);
                if (prevLength != 0 || nextLength != 0) {
                    start.put(num - prevLength, fullLength);
                    end.put(num + nextLength, fullLength);
                }
            }
        }
        return max;
    }

    public int longestConsecutive1(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> range = new HashMap<>();
        int prev, next, prevLength, nextLength;
        int full, max = 0;
        for (int num : arr) {
            if (!range.containsKey(num)) {
                range.put(num, 1);
                prev = num - 1;
                next = num + 1;
                prevLength = range.getOrDefault(prev, 0);
                nextLength = range.getOrDefault(next, 0);
                full = 1 + prevLength + nextLength;
                max = Math.max(max, full);
                range.put(num - prevLength, full);
                range.put(num + nextLength, full);
            }
        }
        return max;
    }

    private void validate() {
        int[] arr = {100, 4, 200, 1, 3, 2, 2, 1, 3};
        int length = longestConsecutive(arr);
        length = longestConsecutive1(arr);
        System.out.println(length);

        arr = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        length = longestConsecutive(arr);
        length = longestConsecutive1(arr);
        System.out.println(length);

        arr = new int[]{0};
        length = longestConsecutive(arr);
        length = longestConsecutive1(arr);
        System.out.println(length);
    }

    static public void main(String... args) {
        new Q128LongestConsecutiveSequence().validate();
    }
}