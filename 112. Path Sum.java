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
    public boolean hasPathSum(TreeNode root, int sum) {
        if ( root == null ) return false;
        return sumhelper(root, 0, sum); 
    }
    public boolean sumhelper(TreeNode node, int presum, int target){
        if( node == null ) return false;
        if( node.left == null && node.right == null && presum+node.val == target) return true;
        return sumhelper(node.left, presum+node.val, target) || sumhelper(node.right, presum+node.val, target);
    }
}
