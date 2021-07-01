package TopInterview;

class Q141LinkedListCycle {

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while (!cycle && null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
            }
        }
        return cycle;
    }

    private ListNode generateList(int[] data, int pos) {
        ListNode head = null, cur = null;
        ListNode node;

        for (int num : data) {
            node = new ListNode(num);
            if (null != head) {
                cur.next = node;
                cur = node;
            } else {
                head = node;
                cur = head;
            }
        }
        ListNode tail = cur;
        cur = head;
        while (pos > 0) {
            --pos;
            cur = cur.next;
        }
        if (pos == 0) {
            tail.next = cur;
        }
        return head;
    }

    static public void main(String... args) {
        Q141LinkedListCycle obj = new Q141LinkedListCycle();
        int[] data = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = obj.generateList(data, pos);
        System.out.println(obj.hasCycle(head));

        data = new int[]{1, 2};
        pos = 0;
        head = obj.generateList(data, pos);
        System.out.println(obj.hasCycle(head));

        data = new int[]{1};
        pos = -1;
        head = obj.generateList(data, pos);
        System.out.println(obj.hasCycle(head));
    }
}