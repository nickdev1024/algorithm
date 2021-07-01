package TopInterview;

class Q160IntersectionTwoLinkedLists {

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        if (headA == null ^ headB == null) {
            return null;
        }
        // at this point, both are not null
        int num = 1;
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode tailA, tailB, intersect = null;
        while (null != curA.next) {
            ++num;
            curA = curA.next;
        }
        tailA = curA;

        --num;
        while (null != curB.next) {
            --num;
            curB = curB.next;
        }
        tailB = curB;

        if (tailA == tailB) {
            curA = headA;
            curB = headB;
            while (num > 0) {
                --num;
                curA = null != curA ? curA.next : null;
            }
            while (num < 0) {
                ++num;
                curB = null != curB ? curB.next : null;
            }
            while (curA != curB) {
                curA = null != curA ? curA.next : null;
                curB = null != curB ? curB.next : null;
            }
            intersect = curA;
        }
        return intersect;
    }

    private ListNode generateList(int[] data) {
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
        while (cur.next != null) {
            System.out.print(arrow + cur.next.val);
            cur = cur.next;
        }
        System.out.println();
    }

    static public void main(String... args) {
        int[] data = {4, 1, 8, 4, 5};
        Q160IntersectionTwoLinkedLists obj = new Q160IntersectionTwoLinkedLists();
        ListNode listA = obj.generateList(data);
        obj.printList(listA);

        data = new int[]{5, 6, 1, 8, 4, 5};
        ListNode listB = obj.generateList(data);
        obj.printList(listB);

        ListNode intersect = obj.getIntersectionNode(listA, listB);
        System.out.println(intersect.val);
    }
}