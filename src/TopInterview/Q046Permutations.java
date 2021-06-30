package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q046Permutations {

    private List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == arr || arr.length == 0) {
            return ans;
        }
        process(arr, 0, ans);
        return ans;
    }

    private void process(int[] arr, int start, List<List<Integer>> ans) {
        int len = arr.length;
        if (start == len) {
            List<Integer> path = new ArrayList<>();
            for (int num : arr) {
                path.add(num);
            }
            ans.add(path);
        } else {
            for (int i = start; i < len; ++i) {
                swap(arr, i, start);
                process(arr, start + 1, ans);
                swap(arr, i, start);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (null == arr || arr.length <= 1 || i == j) {
            return;
        }
        int len = arr.length;
        if (i < 0 || j < 0 || i >= len || j >= len) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    static public void main(String... args) {
        int[] arr = {1, 2, 3};
//        int[] arr = {'a', 'b', 'c'};
        Q046Permutations obj = new Q046Permutations();
        List<List<Integer>> lists = obj.permute(arr);
        int size;
        for (List<Integer> list : lists) {
            size = list.size();
            if (size > 0) {
                System.out.print(list.get(0));
                for (int i = 1; i < size; ++i) {
                    System.out.print(" " + list.get(i));
                }
                System.out.println();
            }
        }
    }
}