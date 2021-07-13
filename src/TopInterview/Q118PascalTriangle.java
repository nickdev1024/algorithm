package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q118PascalTriangle {

    public List<List<Integer>> generate(int rows) {
        if (rows <= 0) {
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;

        int i, row, len;
        for (int idx = 1; idx <= rows; idx++) {
            len = idx;
            // current row
            row = idx - 1;
            list = new ArrayList<>();
            // add 1 at the left
            list.add(1);
            // add value in the middle by adding values from previous row
            for (i = 1; i < len - 1; ++i) {
                list.add(lists.get(row - 1).get(i - 1) + lists.get(row - 1).get(i));
            }
            // add 1 at the right, if not out of bound
            if (i == len - 1) {
                list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }

    private void printList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void validate() {
        int num = 5;
        List<List<Integer>> lists = generate(num);
        printList(lists);

        num = 6;
        lists = generate(num);
        printList(lists);
    }

    static public void main(String... args) {
        new Q118PascalTriangle().validate();
    }
}