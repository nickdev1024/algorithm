package TopInterview;

class Q234PalindromeLinkedList {

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

    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode cur, end;
        ListNode slow = head;
        ListNode fast = head;

        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // after the while loop, slow will be pointing to the mid node
        ListNode tail = slow;
        cur = slow.next;
        ListNode next;

        tail.next = null;

        // use this loop to reverse the pointer
        while (null != cur) {
            next = cur.next;
            cur.next = tail;
            tail = cur;
            cur = next;
        }

        cur = head;
        end = tail;
        boolean isPalindrome = false;
        while (null != cur && null != end && (isPalindrome = cur.val == end.val)) {
            cur = cur.next;
            end = end.next;
        }

        // this part is to reverse back to original order
        cur = tail;
        end = null;
        while (null != cur) {
            next = cur.next;
            cur.next = end;
            end = cur;
            cur = next;
        }
        return isPalindrome;
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
        int[] data = {1, 2, 3, 3, 2, 1};
        Q234PalindromeLinkedList obj = new Q234PalindromeLinkedList();
        ListNode list = obj.generateList(data);

        System.out.println(obj.isPalindrome(list));
        obj.printList(list);

        data = new int[]{1, 2, 3, 2, 1};
        list = obj.generateList(data);

        System.out.println(obj.isPalindrome(list));
        obj.printList(list);
    }
}