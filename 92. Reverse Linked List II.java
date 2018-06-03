/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if ( head == null || head.next == null || m == n) return head;
        ListNode Head = new ListNode(0);
        
        Head.next = head;
        ListNode tail = head;
        for ( int i = 0; i < m - 2; i++){
            head = head.next;
        }
        ListNode tmphead;
        if ( m == 1 ) 
            tmphead = Head;
        else{
            tmphead = head;
            head = head.next;
        }
        for ( int i = 0; i < n - 1; i++){
            tail = tail.next;
        }
        ListNode tmp = head.next;
        head.next = tail.next;
        head = tmp;
        while ( head != tail ){
            tmp = head.next;
            head.next = tmphead.next;
            tmphead.next = head;
            head = tmp;
        }
        tmp = head.next;
        head.next = tmphead.next;
        tmphead.next = head;
        head = tmp;
        return Head.next;
    }
}
