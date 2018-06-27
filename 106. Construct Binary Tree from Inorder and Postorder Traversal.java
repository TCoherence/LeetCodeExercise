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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ( inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 ) return null;
        return helperbuilder(postorder.length - 1, postorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode helperbuilder(int postIndex, int[] postorder, int[] inorder, int instart, int inend){
        // para check
        if ( instart > inend ) 
            return null;
        // build rootNode and find rootval in inorder array
        int rootval = postorder[postIndex];
        TreeNode root = new TreeNode(rootval);
        
        if ( instart == inend )
            return root;
        
        int inIndex = -1;
        for ( int i = instart; i <= inend; i++ ) {
            if( inorder[i] == rootval ) 
                inIndex = i;
        }
        // build left node and right node
        TreeNode left  = helperbuilder(postIndex - inend + inIndex - 1, postorder, inorder, instart, inIndex - 1);
        TreeNode right = helperbuilder(postIndex - 1, postorder, inorder, inIndex + 1, inend);
        // splice them
        root.left  = left;
        root.right = right;
        // return
        return root;
    }
}
