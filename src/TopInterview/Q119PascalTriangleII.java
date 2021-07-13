package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q119PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }
        List<Integer> prev = list;
        list = new ArrayList<>();
        int rows = rowIndex + 1;
        int i, len;
        for (int idx = 2; idx < rows; idx++) {
            len = idx + 1;
            list.add(1);
            for (i = 1; i < len - 1; i++) {
                list.add(prev.get(i - 1) + prev.get(i));
            }
            if (i == len - 1) {
                list.add(1);
            }
            prev = list;
            list = new ArrayList<>();
        }
        return prev;
    }

    private void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void validate() {
        int idx = 5;
        List<Integer> list = getRow(idx);
        printList(list);

        idx = 0;
        list = getRow(idx);
        printList(list);

        idx = 1;
        list = getRow(idx);
        printList(list);
    }

    static public void main(String... args) {
        new Q119PascalTriangleII().validate();
    }
}