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
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) return true;
        if ( isValid(root) ) {
            return isValidBST(root.left) && isValidBST(root.right);
        }
        else return false;
    }
    
    public boolean isValid(TreeNode root){
        boolean ret = true;
        if ( root.left != null) ret &= root.val > root.left.val;
        if ( root.right != null ) ret &= root.val < root.right.val;
        return ret;
    }
}
