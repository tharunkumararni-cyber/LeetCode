class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode a = sortList(head);
        ListNode b = sortList(slow);

        return merge(a, b);
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), cur = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        cur.next = (a != null) ? a : b;
        return dummy.next;
    }
}