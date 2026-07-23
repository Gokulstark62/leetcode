/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseLL(ListNode l) {
        if (l == null || l.next == null)
            return l;

        ListNode temp = reverseLL(l.next);

        l.next.next = l;
        l.next = null;

        return temp;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseLL(l1);
        ListNode r2 = reverseLL(l2);
        ListNode result = null;
        int carry = 0;

        while (r1 != null || r2 != null) {
            int addition = carry;

            if (r1 != null) {
                addition += r1.val;
                r1 = r1.next;
            }

            if (r2 != null) {
                addition += r2.val;
                r2 = r2.next;
            }

            int val = addition % 10;
            carry = addition / 10;

            result = result != null ? new ListNode(val, result) : new ListNode(val);
        }

        if (carry > 0) {
            result = new ListNode(carry, result);
        }

        return result;
    }
}