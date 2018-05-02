/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode Head, int n) {
        ListNode head = Head;   
        ListNode tail = Head;
        int count = 0;
        while( count != n ){
            tail = tail.next;
            count++;
            // if n > len of Head, delete the first node and return
            if ( tail == null ){
                Head = Head.next;
                return Head;
            }
        }
        // while loop ends, to find the nth from the end
        while( tail.next != null ){
            head = head.next;
            tail = tail.next;
        }
        // find the position
        head.next = head.next.next;
        return Head;
        
    }
}
