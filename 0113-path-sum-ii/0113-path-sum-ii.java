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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    private void pathSum(TreeNode node, int target, List<Integer> ds, List<List<Integer>> ans){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null && target == node.val){
            ds.add(node.val);
            ans.add(new ArrayList<>(ds));
            ds.remove(ds.size() - 1);
            return;
        }
        
        //left
        ds.add(node.val);
        pathSum(node.left, target - node.val, ds, ans);
        // ds.remove(ds.size() - 1);

        //right
        // ds.add(node.val);
        pathSum(node.right, target - node.val, ds, ans);
        ds.remove(ds.size() - 1);
    }
}