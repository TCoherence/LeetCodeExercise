/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // check para
        if ( head == null ) return null;
        
        // create new Head
        ListNode Head = new ListNode(0);
        
        // split original list into a sorted list and a unsorted list
        Head.next = head;
        head = head.next;
        Head.next.next = null;
        
        // loop unsorted linked list
        while ( head != null ){
            ListNode pre = Head;
            ListNode post = Head.next;
            while( post != null && post.val < head.val ) {
                pre = pre.next;
                post = post.next;
            }
            if ( post == null ) {
                pre.next = head;
                head = head.next;
                pre.next.next = null;
            }
            else{
                ListNode tmp = head;
                head = head.next;
                tmp.next = post;
                pre.next = tmp;
            }
        }
        return Head.next;
    }
}
