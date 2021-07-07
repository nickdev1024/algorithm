package code;

import java.util.HashMap;
import java.util.Map;

/**
 * In an array, if a number appears more than half of the size, then it is a majority number
 */
class Q002MajorityNumber {

    private int majorityNumber(int[] arr) {
        int invalid = -1;
        if (null == arr || arr.length == 0) {
            return invalid;
        }
        int frequency = 1;
        int candidate = arr[0];
        int len = arr.length;

        for (int i = 1; i < len; ++i) {
            if (frequency == 0) {
                candidate = arr[i];
                frequency = 1;
            } else if (arr[i] == candidate) {
                ++frequency;
            } else {
                --frequency;
            }
        }
        if (frequency >= 1) {
            int count = 0;
            int i = 0;
            boolean moreThanHalf = false;
            int half = len >> 1;
            while (i < len && !moreThanHalf) {
                count += arr[i++] == candidate ? 1 : 0;
                moreThanHalf = count > half;
            }
            if (moreThanHalf) {
                return candidate;
            }
        }
        return invalid;
    }

    private int test(int[] arr) {
        int invalid = -1;
        if (null == arr || arr.length == 0) {
            return invalid;
        }
        int len = arr.length;
        int half = (len >> 1);
        Map<Integer, Integer> dict = new HashMap<>();
        for (int num : arr) {
            if (!dict.containsKey(num)) {
                dict.put(num, 1);
            } else {
                dict.put(num, dict.get(num) + 1);
            }
            if (dict.get(num) > half) {
                return num;
            }
        }
        return invalid;
    }

    private int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed + 1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed);
        }
        return arr;
    }

    private void printArray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        System.out.print(arr[0]);
        String space = " ";
        for (int i = 1; i < len; ++i) {
            System.out.print(space + arr[i]);
        }
        System.out.println();
    }

    private void validate() {
        int[] arr;
        int seed = 100;
        int num1, num2;

        int million = 1_000_000;
        System.out.println("test started ...");
        for (int i = 0; i < million; i++) {
            arr = generateRandArray(seed);
            num1 = majorityNumber(arr);
            num2 = test(arr);

            if (num1 != num2) {
                printArray(arr);
                System.out.println(num1);
                System.out.println(num2);
                System.err.println("test failed ...");
                return;
            }
        }
        System.out.println("test passed ...");
    }

    static public void main(String... args) {
        new Q002MajorityNumber().validate();
    }
}