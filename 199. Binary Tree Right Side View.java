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
    public List<Integer> rightSideView(TreeNode root) {
        // check para
        if ( root == null ) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while ( !q.isEmpty() ) {
            int size = q.size();
            for ( int i = 0; i < size - 1; i++ ) {
                TreeNode node = q.poll();
                if ( node.left != null ) q.offer(node.left);
                if ( node.right!= null ) q.offer(node.right);
            }
            TreeNode node = q.poll();
            if ( node.left != null ) q.offer(node.left);
            if ( node.right!= null ) q.offer(node.right);
            res.add(node.val);
        }
        return res;
    }
}
