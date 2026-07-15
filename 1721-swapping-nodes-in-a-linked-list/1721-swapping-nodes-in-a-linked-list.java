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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow=head,fast=head;
        for(int i=1;i<k;i++)
        slow=slow.next;
        ListNode curr = slow;
        while(curr.next!=null){
            curr = curr.next;
            fast=fast.next;
        }
        int t = slow.val;
        slow.val = fast.val;
        fast.val =t;
        return head;
    }
}