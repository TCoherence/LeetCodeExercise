/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if ( head == null || head.next == null || head.next.next == null ) return null;
        ListNode walker = head.next;
        ListNode runner = head.next.next;
        while ( runner.next != null && runner.next.next != null ) {
            if ( runner == walker ) {
                if ( runner == head ) return head;
                else break;
            }
            else{
                runner = runner.next.next;
                walker = walker.next;
            }
        }
        if ( runner.next == null || runner.next.next == null ) return null;
        runner = head;
        while ( runner != walker ) {
            runner = runner.next;
            walker = walker.next;
        }
        return runner;
    }
}
