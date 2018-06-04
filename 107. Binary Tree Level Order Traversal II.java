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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        if ( root == null ) return res;
        queue.offer(root);
        while( !queue.isEmpty() ){
            int n = queue.size();
            TreeNode tmp;
            for ( int i = 0; i < n; i++ ){
                tmp = queue.poll();
                list.add(tmp.val);
                if ( tmp.left != null ) queue.offer(tmp.left);
                if ( tmp.right != null) queue.offer(tmp.right);
            }
            res.add(0, list);
            list = new ArrayList<Integer>();
        }
        return res;
    }
}
