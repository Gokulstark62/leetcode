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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        if(head.val > 4) {
            ListNode node = new ListNode(1);
            curr.next = node;
            curr = curr.next;
        }

        curr.next = head;
        while(head != null) {
            int carry = 0;

            if(head.next != null && head.next.val > 4) {
                carry = 1;
            }

            head.val = (2 * head.val + carry) % 10;
            head = head.next;
        } 

        return dummy.next;
    }
}