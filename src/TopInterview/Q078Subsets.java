package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q078Subsets {

    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        collect(arr, idx, list, ans);
        return ans;
    }

    private void collect(int[] arr, int idx, List<Integer> list, List<List<Integer>> ans) {
        if (idx >= arr.length) {
            List<Integer> res = new ArrayList<>(list);
            ans.add(res);
            return;
        }
        list.add(arr[idx]);
        collect(arr, idx + 1, list, ans);
        list.remove(list.size() - 1);
        collect(arr, idx + 1, list, ans);
    }

    private void printList(List<List<Integer>> subsets) {
        for (List<Integer> subset : subsets) {
            for (Integer num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private void validate() {
        int[] num = {1, 2, 3};
        List<List<Integer>> subsets = subsets(num);
        printList(subsets);
    }

    static public void main(String... args) {
        Q078Subsets obj = new Q078Subsets();
        obj.validate();
    }
}