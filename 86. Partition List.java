/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // two pointers, one start one to find the node need to be taken out and put it into the right place.
        
        // para check
        if ( head == null ) return null;
        
        
        // create 2 pointer
        ListNode Head = new ListNode(0);
        Head.next = head;
        ListNode slow = Head;
        ListNode fast = Head;
        
        while ( fast != null ) {
            // cur <= x, then find a smaller one, if no one break, or take that one into the right place.
            while ( slow.next != null && slow.next.val < x ) slow = slow.next;
            fast = slow;
            while ( fast.next != null && fast.next.val >= x ) fast = fast.next;
            
            //
            if ( fast.next == null && fast.val >= x ) break;
            if ( slow == fast ) break;
            // ops
            ListNode tmp = fast.next;
            fast.next = fast.next.next;
            tmp.next = slow.next;
            slow.next = tmp;
            
                        
            // slow move one step.
            fast = slow.next;
            slow = fast;
        }
        return Head.next;
    }
}
