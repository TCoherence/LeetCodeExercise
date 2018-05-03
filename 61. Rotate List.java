/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null || k < 0 ) return null;
        ListNode Head = new ListNode(0);
        Head.next = head;
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        ListNode newTail = head;
        for ( int i = 1; i < len - k%len; i++){
            newTail = newTail.next;            
        }
        tail.next = Head.next;
        Head.next = newTail.next;
        newTail.next = null;
        return Head.next;
    }
}
