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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        
        if ( root == null ) return res;
        queue.offer(root);
        while( !queue.isEmpty() ){
            int n = queue.size();
            double ret = 0.0;
            for ( int i = 0; i < n; i++ ){
                TreeNode head = queue.poll();
                ret += head.val;
                if ( head.left != null ) queue.offer(head.left);
                if ( head.right != null) queue.offer(head.right);
            }
            ret = ret / n;
            res.add(ret);
        }
        return res;
    }
}
