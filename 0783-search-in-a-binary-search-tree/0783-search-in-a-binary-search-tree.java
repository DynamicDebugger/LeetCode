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
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
    //preorder
    private TreeNode search(TreeNode node, int val){
        if(node == null || node.val == val){
            return node;
        }

        // Search in the left subtree
        TreeNode leftResult = search(node.left, val);
        if (leftResult != null) {
            return leftResult;  // If found in left subtree, return immediately
        }

        // Search in the right subtree if not found in the left subtree
        return search(node.right, val);

    }
}