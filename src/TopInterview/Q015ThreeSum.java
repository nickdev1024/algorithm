package TopInterview;

import java.util.ArrayList;
import java.util.List;

class Q015ThreeSum {

    private void mergeSort(int[] arr) {
        if (null == arr || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        doSort(arr, left, right);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = ((right - left) >> 1) + left;
        doSort(arr, left, mid);
        doSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        int[] help = new int[len];
        int i = 0, p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < len; ++i) {
            arr[left + i] = help[i];
        }
    }

    private List<List<Integer>> threeSum(int[] arr) {
        int min = 3;
        List<List<Integer>> ans = new ArrayList<>();
        if (null == arr || arr.length < min) {
            return ans;
        }
        mergeSort(arr);
        int len = arr.length;
        int idx0 = 0, idx1 = 1;
        int left, lastIdx = len - 1;
        int twoSum, zero = 0;
        List<Integer> list;
        List<int[]> twoSums;
        for (int i = 0; i <= len - min; ++i) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                left = i + 1;
                twoSum = zero - arr[i];
                twoSums = twoSum(arr, twoSum, left, lastIdx);
                if (twoSums.size() > 0) {
                    for (int[] sum : twoSums) {
                        list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(sum[idx0]);
                        list.add(sum[idx1]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    private List<int[]> twoSum(int[] arr, int twoSum, int left, int right) {
        int len = 2;
        if (null == arr || right - left + 1 < len || arr.length < len) {
            return null;
        }
        List<int[]> ans = new ArrayList<>();
        int[] each;
        int sum;
        int idx0 = 0, idx1 = 1;
        int leftIdx = left;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum < twoSum) {
                ++left;
            } else if (sum > twoSum) {
                --right;
            } else {
                if (left == leftIdx || arr[left - 1] != arr[left]) {
                    each = new int[len];
                    each[idx0] = arr[left];
                    each[idx1] = arr[right];
                    ans.add(each);
                }
                ++left;
            }
        }
        return ans;
    }

    private void printList(int[] arr, List<List<Integer>> list) {
        if (null == list || list.size() == 0) {
            return;
        }
        int len;
        String empty = "empty";
        int idx, idx0 = 0;
        String joiner = " ~ ";
        for (List<Integer> each : list) {
            len = each.size();
            if (len != 0) {
                idx = each.get(idx0);
//                System.out.print(arr[idx] + joiner + idx);
                System.out.print(idx);
                for (int i = 1; i < len; ++i) {
                    idx = each.get(i);
//                    System.out.print(" " + arr[idx] + joiner + idx);
                    System.out.print(" " + idx);
                }
                System.out.println();
            } else {
                System.out.println(empty);
            }
        }
    }

    static public void main(String... args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans;
        Q015ThreeSum obj = new Q015ThreeSum();
        ans = obj.threeSum(arr);
        obj.printList(arr, ans);
    }
}