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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null || p == null || q == null ) return null;
        if ( p.val > q.val ) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        if ( root.val == p.val || root.val == q.val )
            return root;
        
        if ( root.val > q.val ) 
            return lowestCommonAncestor(root.left, p, q);
        if ( root.val < p.val ) 
            return lowestCommonAncestor(root.right, p, q);
        // if ( root.val > p.val && root.val < q.val ) 
        return root;
    }
}
