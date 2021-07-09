package TopInterview;

class Q023MergeKSortedLists {

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

    private int size = 0;

    private void heapInsert(ListNode[] heap, int idx) {
        int root, smallest;
        while ((root = ((idx - 1) >> 1)) >= 0) {
            smallest = heap[root].val <= heap[idx].val ? root : idx;
            if (smallest == root) {
                break;
            }
            swap(heap, smallest, root);
            idx = root;
        }
    }

    private void heapify(ListNode[] heap, int idx) {
        int left, right, smallest;
        while ((left = (idx << 1) + 1) < size) {
            smallest = (right = left + 1) < size && heap[right].val <= heap[left].val ? right : left;
            smallest = heap[smallest].val <= heap[idx].val ? smallest : idx;
            if (smallest == idx) {
                break;
            }
            swap(heap, smallest, idx);
            idx = smallest;
        }
    }

    private void swap(ListNode[] heap, int i, int j) {
        if (i != j) {
            ListNode tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        // add to heap
        ListNode[] heap = new ListNode[len];
        for (ListNode head : lists) {
            if (null != head) {
                heap[size] = head;
                heapInsert(heap, size++);
            }
        }
        ListNode head = null;
        ListNode cur = null;
        int i;
        while (size != 0) {
//            node = new ListNode(heap[0].val);
            if (head != null) {
                cur.next = heap[0];
                cur = cur.next;
            } else {
                head = heap[0];
                cur = head;
            }
            if (heap[0].next != null) {
                heap[0] = heap[0].next;
            } else {
                swap(heap, 0, --size);
            }
            i = size - 1;
            while (i >= 0) {
                heapify(heap, i--);
            }
        }
        return head;
    }

    private ListNode generateList(int[] arr) {
        ListNode head = null;
        ListNode cur = null;
        ListNode node;

        for (int val : arr) {
            node = new ListNode(val);
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
        String space = " ";
        while (cur.next != null) {
            System.out.print(space + cur.next.val);
            cur = cur.next;
        }
        System.out.println();
    }

    private void validate() {
        int[][] data = {
                {1, 4, 5},
                {1, 3, 4},
                {2, 6},
                {3, 5, 8, 9, 10},
        };
        int len = data.length;
        ListNode[] lists = new ListNode[len];
        for (int i = 0; i < len; ++i) {
            lists[i] = generateList(data[i]);
        }
        for (ListNode list : lists) {
            printList(list);
        }
        ListNode list = mergeKLists(lists);
        printList(list);
    }

    static public void main(String... args) {
        new Q023MergeKSortedLists().validate();
    }
}