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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(0, post.length - 1, post, pre, 0, pre.length - 1);
    }
    public TreeNode helper(int postStart, int postEnd, int[] post, int[] pre, int preStart, int preEnd) {
        // System.out.printf("postStart = %d, postEnd = %d, preStart = %d, preEnd = %d\n", postStart, postEnd, preStart, preEnd);
        if ( postEnd < postStart ) return null;
        if ( postStart == postEnd ) {
            // System.out.printf("Going to return node %d\n", post[postEnd]);
            return new TreeNode(post[postEnd]);
        }
        TreeNode root = new TreeNode(post[postEnd]);
        
        int left = -1, right = -1;
        // find right in post
        for ( int i = postStart; i <= postEnd; i++ ) {
            if ( post[i] == pre[preStart + 1] ) {
                right = i;
                break;
            }
        }
        // find left in pre
        for ( int i = preStart; i <= preEnd; i++ ) {
            if ( pre[i] == post[postEnd - 1] ) {
                left = i;
                break;
            }
        }
        if ( pre[left] == post[right] ) {
            root.left  = helper(postStart, right, post, pre, left, preEnd);
            root.right = null;
        }
        else {
            root.left  = helper(postStart, right, post, pre, preStart + 1, left - 1);
            root.right = helper(right + 1, postEnd - 1, post, pre, left, preEnd);
        }
        // System.out.printf("root = %d, root.left = %d, root.right = %d\n", root.val, root.left.val, root.right.val);
        return root;
    }
}
