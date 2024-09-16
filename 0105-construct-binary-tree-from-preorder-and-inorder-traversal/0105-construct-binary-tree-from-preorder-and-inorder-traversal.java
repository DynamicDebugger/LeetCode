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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0 ; i < inorder.length ; i++){
            inMap.put(inorder[i], i);
        }
        return creation(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode creation(int[] preorder, int preS, int preE,int[] inorder, int inS, int inE, Map<Integer,Integer> inMap){

        if(preS > preE || inS > inE)    return null;

        TreeNode node = new TreeNode(preorder[preS]);
        int inRoot = inMap.get(node.val);
        int numsLeft = inRoot - inS;

        node.left = creation(preorder, preS + 1, preS + numsLeft,
                             inorder, inS, inRoot - 1, inMap);
        node.right = creation(preorder, preS + numsLeft + 1, preE,
                             inorder, inRoot + 1, inE, inMap);
        return node;
    }
}