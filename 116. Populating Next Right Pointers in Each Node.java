/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // -------------   SOLUTION 1   --------------
    public void connect(TreeLinkNode root) {
        /* BFS to go through every level of the tree, but const extra space required, so drop this scheme.
         * DFS through the left node and right node. Need pay attention to the left's right node and right's left node connection.
         *
         *
         */
        
        // check para
        if ( root == null ) return ;
        root.next = null;
        
        // helper func
        helper(root.left, root.right);
    }
    public void helper(TreeLinkNode left, TreeLinkNode right){
        if ( left == null && right == null ) return;
        // same level
        left.next = right;
        right.next = null;
        // 1. next level of left node
        helper(left.left, left.right);
        // 2. connect left's right and right's left, judge first, in case of the botton level
        helper(left.right, right.left);
        // 3. next level of right node
        helper(right.left, right.right);
       
    // -------------   SOLUTION 2   ----------------
    // this solution take use of the next pointer which is better.
    // only present the helper function
    public void helper2(TreeLinkNode root){
        if ( root.left == null ) return;
        root.left.next = root.right;
        if ( root.next != null ){
            root.right.next = root.next.left;
        }
        else{
            // root.right.next = null; // we dont need this in fact
        }
        helper2(root.left);
        helper2(root.right);
    }
    
}
