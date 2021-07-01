package TopInterview;

class Q237DeleteNodeLinkedList {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private ListNode generateList(int[] data) {
        ListNode head = null, cur = null;
        ListNode node;

        for (int num : data) {
            node = new ListNode(num);
            if (null != head) {
                cur.next = node;
                cur = cur.next;
            } else {
                head = node;
                cur = node;
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

    private ListNode getNode(ListNode head, int value) {
        if (null == head) {
            return null;
        }
        while (head != null && head.val != value) {
            head = head.next;
        }
        return head;
    }

    static public void main(String... args) {
        int[] data = {4, 5, 1, 9};
        Q237DeleteNodeLinkedList obj = new Q237DeleteNodeLinkedList();
        ListNode list = obj.generateList(data);
        obj.printList(list);
        int value = 5;
        ListNode node = obj.getNode(list, value);
        obj.deleteNode(node);
        obj.printList(list);

        list = obj.generateList(data);
        obj.printList(list);
        value = 1;
        node = obj.getNode(list, value);
        obj.deleteNode(node);
        obj.printList(list);
    }
}