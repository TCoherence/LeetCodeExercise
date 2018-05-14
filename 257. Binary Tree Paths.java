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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if ( root == null ) return res;
        binaryTreePaths(root, res, sb, 0);
        return res;
    }
    public void binaryTreePaths(TreeNode node, List<String> res, StringBuilder sb, int lenBefore){
        sb.append(node.val);
        if ( node.left == null && node.right == null ) {
            res.add(sb.toString());
            sb.setLength(lenBefore);
            return;
        }
        sb.append("->");
        if ( node.left != null ) {
            binaryTreePaths(node.left, res, sb, sb.length());
           
        }
        if ( node.right != null ) {
            binaryTreePaths(node.right, res, sb, sb.length());
        }
        sb.setLength(lenBefore);
        
    }
}
