package TopInterview;

class Q021MergeTwoSortedLists {

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;

        while (null != l1 && null != l2) {
            if (null != head) {
                cur.next = l1.val <= l2.val ? l1 : l2;
                cur = cur.next;
            } else {
                head = l1.val <= l2.val ? l1 : l2;
                cur = head;
            }
            l1 = cur == l1 ? l1.next : l1;
            l2 = cur == l2 ? l2.next : l2;
        }
        if (head == null) {
            head = (null != l1) ? l1 : l2;
        } else {
            cur.next = (null != l1) ? l1 : l2;
        }
        return head;
    }

    private ListNode generateList(int[] arr) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode cur = null;
        ListNode node;
        for (int val : arr) {
            node = new ListNode(val);
            if (null != head) {
                cur.next = node;
                cur = node;
            } else {
                cur = head = node;
            }
        }
        return head;
    }

    private void printList(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode cur = head;
        System.out.print(cur.val);
        cur = cur.next;
        String arrow = " -> ";
        while (null != cur) {
            System.out.print(arrow + cur.val);
            cur = cur.next;
        }
    }

    static public void main(String... args) {
        Q021MergeTwoSortedLists obj = new Q021MergeTwoSortedLists();
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = obj.generateList(arr1);
        ListNode l2 = obj.generateList(arr2);

        ListNode list = obj.mergeTwoLists(l1, l2);
        obj.printList(list);
    }
}