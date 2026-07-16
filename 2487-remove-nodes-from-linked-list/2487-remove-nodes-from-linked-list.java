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
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        if(head == null) return null;

        ListNode temp = head;
        ListNode reversed = reverse(temp);
        ListNode curr = reversed;

        int max = curr.val;
        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
                max = curr.val;
            }
        }
        ListNode result = reverse(reversed);
        return result;
    }
}