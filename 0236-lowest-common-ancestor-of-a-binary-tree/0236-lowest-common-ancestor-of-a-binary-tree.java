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
        return LCA(root, p, q);
    }
    private TreeNode LCA(TreeNode node, TreeNode p, TreeNode q){
        
        if(node == null || node.val == p.val || node.val == q.val)
            return node;

        TreeNode l = LCA(node.left, p, q);
        TreeNode r = LCA(node.right, p, q);
        if(l == null){
            return r;
        }else if(r == null){
            return l;
        }else{
            return node;
        }
    }
}