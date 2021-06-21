package TopInterview;

class Q002AddTwoNumbers {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode cur = null;
        ListNode res = null;
        int val, increment = 0;
        int base = 10;

        while (null != cur1 || null != cur2) {
            val = increment;
            if (cur1 != null) {
                val += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                val += cur2.val;
                cur2 = cur2.next;
            }
            increment = val / base;
            val %= base;
            if (null != res) {
                cur.next = new ListNode(val);
                cur = cur.next;
            } else {
                res = new ListNode(val);
                cur = res;
            }
        }
        if (increment > 0) {
            cur.next = new ListNode(increment);
        }
        return res;
    }

    private ListNode generateList(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        ListNode list = new ListNode(arr[0]);
        ListNode cur = list;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return list;
    }

    private int[] addTwoArr(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = Math.max(len1, len2);
        int[] arr = new int[len];
        int i = 0;
        int value, increment = 0;
        int base = 10;
        while (i < len1 || i < len2) {
            value = increment;
            value += i < len1 ? arr1[i] : 0;
            value += i < len2 ? arr2[i] : 0;
            arr[i++] = value % base;
            increment = value >= base ? 1 : 0;
        }
        if (increment > 0) {
            int[] copy = new int[len + 1];
            System.arraycopy(arr, 0, copy, 0, len);
            copy[len] = increment;
            arr = copy;
        }
        return arr;
    }

    private boolean equal(ListNode head, int[] sum) {
        boolean equal = true;
        ListNode cur = head;
        int len = sum.length;
        int i = 0;
        while (i < len && null != cur && equal) {
            equal = cur.val == sum[i++];
            cur = cur.next;
        }
        if (i < len || cur != null) {
            return false;
        }
        return equal;
    }

    static public void main(String... args) {
        int[] arr1, arr2, sum;
        ListNode list1, list2, list;
        Q002AddTwoNumbers obj = new Q002AddTwoNumbers();

        arr1 = new int[]{2, 4, 3};
        arr2 = new int[]{5, 6, 4};
        list1 = obj.generateList(arr1);
        list2 = obj.generateList(arr2);

        list = obj.addTwoNumbers(list1, list2);
        sum = obj.addTwoArr(arr1, arr2);
        if (!obj.equal(list, sum)) {
            System.err.println("1. failed ...");
            return;
        }

        arr1 = new int[]{0};
        arr2 = new int[]{0};
        list1 = obj.generateList(arr1);
        list2 = obj.generateList(arr2);

        list = obj.addTwoNumbers(list1, list2);
        sum = obj.addTwoArr(arr1, arr2);
        if (!obj.equal(list, sum)) {
            System.err.println("2. failed ...");
            return;
        }

        arr1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        arr2 = new int[]{9, 9, 9, 9};
        list1 = obj.generateList(arr1);
        list2 = obj.generateList(arr2);

        list = obj.addTwoNumbers(list1, list2);
        sum = obj.addTwoArr(arr1, arr2);
        if (!obj.equal(list, sum)) {
            System.err.println("3. failed ...");
            return;
        }
        System.out.println("passed ...");
    }
}
