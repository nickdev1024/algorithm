package TopInterview;

class Q019RemoveNthNodeFromEndList {

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n <= 0) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (null != cur) {
            --n;
            if (n == -1) {
                prev = head;
            }
            if (n < -1) {
                prev = prev.next;
            }
            cur = cur.next;
        }
        if (n == 0) {
            return head.next;
        }
        if (n > 0) {
            return head;
        }
        prev.next = prev.next.next;
        return head;
    }

    private ListNode generateList(int[] data) {
        if (null == data || data.length == 0) {
            return null;
        }
        ListNode head = new ListNode(data[0]);
        ListNode cur = head;
        int len = data.length;
        for (int i = 1; i < len; ++i) {
            cur.next = new ListNode(data[i]);
            cur = cur.next;
        }
        return head;
    }

    private void printList(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode cur = head;
        String arrow = " -> ";
        System.out.print("list: " + cur.val);
        while (cur.next != null) {
            cur = cur.next;
            System.out.print(arrow + cur.val);
        }
        System.out.println();
    }

    private void validate() {
        int[] data = {1, 2, 3, 4, 5};
        ListNode list = generateList(data);
        printList(list);
        ListNode head = removeNthFromEnd(list, 4);
        printList(head);
    }

    static public void main(String... args) {
        new Q019RemoveNthNodeFromEndList().validate();
    }
}