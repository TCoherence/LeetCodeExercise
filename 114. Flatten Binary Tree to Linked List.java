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
    public void flatten(TreeNode root) {
        // DFS and flatten every node in the path
        
        // check para
        if ( root == null ) return ;
        // flatten left and right
        
        flatten(root.left);
        flatten(root.right);
        
        if ( root.left == null ) return ;

        // splice left to right and nullify the root.left
        TreeNode leftfirst = root.left;
        TreeNode leftlast  = root.left;
        while ( leftlast.right  != null ) leftlast  = leftlast.right;
        leftlast.right = root.right;
        root.right = leftfirst;
        root.left = null;
    }
}
