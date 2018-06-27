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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helperbuilder(0, preorder, inorder, 0, inorder.length - 1);
    }
    /** 
     *  int     rootindex   index of root val
     *  int[]   preorder    subpreorder array
     *  int[]   inorder     subinorder arryay
     *  int     ins         start index of subinorder array
     *  int     inend       end index of subinorder array
     */
    public TreeNode helperbuilder(int preRootIdx, int[] preorder, int[] inorder, int ins, int inend){
        // para check
        if (ins > inend )
            return null;
        // build root and find its index
        int rootval = preorder[preRootIdx];
        TreeNode root = new TreeNode(rootval);
        
        if ( ins == inend ) {
            return root;
        }
        
        int rootIndex = -1;
        for ( int i = ins; i <= inend; i++){
            if ( inorder[i] == rootval ) 
                rootIndex = i; // no duplicates guarantee
        }
        
        // compute left root & right root
        // if ( ins == inend ) {
        //     return root;
        // }
        TreeNode left  = helperbuilder(preRootIdx + 1,                   preorder, inorder, ins,           rootIndex - 1);
        TreeNode right = helperbuilder(preRootIdx + rootIndex + 1 - ins, preorder, inorder, rootIndex + 1, inend);
        // splice 
        root.left = left;
        root.right = right;
        // return
        return root;
    }
}
