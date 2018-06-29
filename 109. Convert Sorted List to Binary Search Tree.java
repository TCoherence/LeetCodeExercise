/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // like 108. Convert Sorted Array to Binary Search Tree,
        // we still need find the mid of linked list, so we can use 2 pointers, slow and fast, to locate the mid
        
        return bstHelper(head, null);
    }
    public TreeNode bstHelper(ListNode head, ListNode tail){
        if ( head == null || head == tail ) return null;
        
        if ( head.next == null ) return new TreeNode(head.val);
        ListNode fast = head.next;
        ListNode slow = head;
        while( fast != tail && fast.next != tail ){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root  = new TreeNode( slow.val);
        root.left  = bstHelper(head, slow);
        root.right = bstHelper(slow.next, tail);
        return root;
    }
    
}
