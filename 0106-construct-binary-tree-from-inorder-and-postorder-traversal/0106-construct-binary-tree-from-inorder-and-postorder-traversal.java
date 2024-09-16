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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();

        for(int i = 0 ; i < inorder.length ; i++){
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0 , postorder.length - 1, inMap);
    }

    private TreeNode buildTree(int[] inorder, int inS, int inE, int[] postorder, int posS, int posE, Map<Integer, Integer> inMap){

        if(inS> inE || posS > posE) return null;

        TreeNode node = new TreeNode(postorder[posE]);

        int inRoot = inMap.get(node.val);
        int numsRight = inE - inRoot;

        node.left = buildTree(inorder, inS, inRoot - 1 , postorder, posS , posE - numsRight -1, inMap);
        node.right = buildTree(inorder,inRoot + 1 , inE, postorder, posE - numsRight , posE - 1 , inMap);

        return node;

    }
}