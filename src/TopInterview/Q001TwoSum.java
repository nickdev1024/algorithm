package TopInterview;

import java.util.HashMap;
import java.util.Map;

class Q001TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = numbers.length;
        int[] ans = new int[]{-1, -1};
        int i = 0;
        boolean found = false;
        int theOther;
        while (i < len && !found) {
            theOther = target - numbers[i];
            if (map.containsKey(theOther)) {
                found = true;
                ans = new int[]{map.get(theOther), i};
            } else {
                map.put(numbers[i], i++);
            }
        }
        return ans;
    }

    static public void main(String... args) {

    }
}
