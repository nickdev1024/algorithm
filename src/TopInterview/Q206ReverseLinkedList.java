package TopInterview;

class Q206ReverseLinkedList {

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

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (null != cur) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode generateList(int[] data) {
        if (null == data || data.length == 0) {
            return null;
        }
        ListNode head = null, cur = null;
        ListNode node;

        for (int num : data) {
            node = new ListNode(num);
            if (null != head) {
                cur.next = node;
            } else {
                head = node;
            }
            cur = node;
        }
        return head;
    }

    private void printList(ListNode head) {
        if (null == head) {
            return;
        }
        ListNode cur = head;
        System.out.print(cur.val);

        String arrow = " -> ";
        while (null != cur.next) {
            System.out.print(arrow + cur.next.val);
            cur = cur.next;
        }
        System.out.println();
    }

    static public void main(String... args) {
        int[] data = {1, 2, 3, 5, 6};
        Q206ReverseLinkedList obj = new Q206ReverseLinkedList();
        ListNode list = obj.generateList(data);
        obj.printList(list);

        ListNode reverse = obj.reverseList(list);
        obj.printList(reverse);

        data = new int[]{1, 2};
        list = obj.generateList(data);
        obj.printList(list);
        reverse = obj.reverseList(list);
        obj.printList(reverse);
    }
}