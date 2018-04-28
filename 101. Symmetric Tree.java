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
    public boolean isSymmetric(TreeNode root) {
        if( root == null ) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        // hit the bottom, otherwise come deeper
        if( left == null && right == null ) return true;
        if( left == null || right == null ) return false;
        if ( left.val != right.val ) return false;
        else  {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
        
    }
}
