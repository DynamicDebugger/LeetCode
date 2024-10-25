/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum);
    }
    private boolean pathSum(TreeNode node, int target){
        if(node == null){
            return false;
        }
        
        if(node.left == null && node.right == null && target == node.val) return true;

        return pathSum(node.left, target - node.val) | pathSum(node.right, target - node.val);
        // return left | right;
    }
}