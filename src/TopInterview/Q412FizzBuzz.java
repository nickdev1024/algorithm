package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q412FizzBuzz {

    public List<String> fizzBuzz(int num) {
        List<String> ans = new ArrayList<>(num);
        String buzz = "Buzz";
        String fizz = "Fizz";
        String fizzBuzz = "FizzBuzz";
        for (int i = 1; i <= num; ++i) {
            if (i % 15 == 0) {
                ans.add(fizzBuzz);
            } else if (i % 3 == 0) {
                ans.add(fizz);
            } else if (i % 5 == 0) {
                ans.add(buzz);
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    private void printList(List<String> list) {
        if (null == list || list.isEmpty()) {
            return;
        }
        int i = 0;
        System.out.print(list.get(i));
        int size = list.size();
        String space = " ";
        for (i = 1; i < size; ++i) {
            System.out.print(space + list.get(i));
        }
        System.out.println();
    }

    static public void main(String... args) {
        int[] data = {3, 5, 15};
        Q412FizzBuzz obj = new Q412FizzBuzz();
        for (int num : data) {
            List<String> list = obj.fizzBuzz(num);
            obj.printList(list);
        }
    }
}