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
    private TreeNode[]  res;
    private TreeNode    prevNode;
    
    public void recoverTree(TreeNode root) {
        prevNode = new TreeNode(Integer.MIN_VALUE);
        res = new TreeNode[2];
        helper(root);
        swap(res[0], res[1]);
    }
    public void helper(TreeNode node) {
        // go to the left-buttom first, recursively
        if ( node == null ) return;
        helper(node.left);
        if ( prevNode.val > node.val && res[0] == null ) {
            res[0] = prevNode;
        }
        if ( prevNode.val > node.val && res[0] != null ) {
            res[1] = node;
        }
        prevNode = node;
        
        helper(node.right);
        
        
        
    }
    public void swap(TreeNode n1, TreeNode n2) { // swap their value is enough
        if ( n1 == null || n2 == null ) return;
        n1.val ^= n2.val;
        n2.val ^= n1.val;
        n1.val ^= n2.val;
    }
}
