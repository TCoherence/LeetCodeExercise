/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode Head = new ListNode(0);
        Head.next = head;
        head = Head;
        while ( head != null ){
            ListNode tail = head.next;
            int cnt = 1;
            //
            while( tail != null  && tail.next != null && tail.val == tail.next.val ){
                cnt++;
                tail = tail.next;
            }
            if ( cnt == 1 ) head = head.next;
            else {
                head.next = tail.next;
            }
            
        }
        return Head.next;
    }
}
