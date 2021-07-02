package TopInterview;

class Q328OddEvenLinkedList {

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

    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode oddHead = null;
        ListNode evenHead = null;

        ListNode oddCur = null, evenCur = null;
        ListNode cur = head;

        int count = 1;
        while (null != cur) {
            if ((count & 1) == 1) {
                // odd
                if (null != oddHead) {
                    oddCur.next = cur;
                    oddCur = oddCur.next;
                } else {
                    oddHead = cur;
                    oddCur = cur;
                }
            } else {
                // even
                if (null != evenHead) {
                    evenCur.next = cur;
                    evenCur = evenCur.next;
                } else {
                    evenHead = cur;
                    evenCur = cur;
                }
            }
            ++count;
            cur = cur.next;
        }
        if (evenCur != null) {
            evenCur.next = null;
        }
        oddCur.next = evenHead;
        return oddHead;
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
                cur = cur.next;
            } else {
                head = node;
                cur = head;
            }
        }
        return head;
    }

    private void printList(ListNode head) {
        if (null == head) {
            return;
        }
        System.out.print(head.val);
        String arrow = " -> ";
        while (null != head.next) {
            System.out.print(arrow + head.next.val);
            head = head.next;
        }
        System.out.println();
    }

    static public void main(String... args) {
        Q328OddEvenLinkedList obj = new Q328OddEvenLinkedList();
        int[] data = {1, 2, 3, 4, 5};
        ListNode list = obj.generateList(data);
        obj.printList(list);

        ListNode oddEven = obj.oddEvenList(list);
        obj.printList(oddEven);

        data = new int[]{2, 1, 3, 5, 6, 4, 7};
        list = obj.generateList(data);
        obj.printList(list);

        oddEven = obj.oddEvenList(list);
        obj.printList(oddEven);
    }
}