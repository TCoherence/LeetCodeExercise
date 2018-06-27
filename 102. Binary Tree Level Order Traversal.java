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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        if ( root == null ) return res;
        q.offer(root);
        TreeNode cur;
        while( !q.isEmpty() ){
            // level order ops, including poll current nodes, offer the coming nodes and store current level vals
            int size = q.size();
            for ( int i = 0; i < size; i++ ){
                cur = q.poll();
                if (cur.left  != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                list.add(cur.val);
            }
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }
}
