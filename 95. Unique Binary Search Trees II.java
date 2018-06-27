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
    public List<TreeNode> generateTrees(int n) {
        // we just store TreeNode because its structure can be reached by the root, which is stored in List<TreeNode>
        
        if ( n == 0 ) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        
        if ( start > end ) {
            list.add(null);
            return list;
        }
        if ( start == end ) {
            list.add(new TreeNode(start));
            return list;
        }
        
        
        for ( int i = start; i <= end; i++ ) {
            //  for root i
            //      get its left and right trees
            List<TreeNode> left  = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            //      splice the left tree and right 
            for ( TreeNode leftnode : left ){
                for ( TreeNode rightnode : right ){
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
