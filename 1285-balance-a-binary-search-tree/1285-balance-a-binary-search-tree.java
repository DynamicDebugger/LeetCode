import java.util.ArrayList;

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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        inOrder(root, ls); // Corrected the method name
        TreeNode dummy = populate(ls); // Initialize TreeNode dummy
        return dummy;
    }

    // In-order traversal to get the sorted list of values
    public void inOrder(TreeNode root, ArrayList<Integer> ls){
        if(root == null) return;
        inOrder(root.left, ls); // Pass the ls parameter
        ls.add(root.val);
        inOrder(root.right, ls); // Pass the ls parameter
    }

    // Populate a balanced BST from sorted list of integers
    public TreeNode populate(ArrayList<Integer> nums){
        return buildBalancedBST(nums, 0, nums.size() - 1); // Directly build a balanced tree
    }

    // Recursive method to build a balanced BST from a sorted array
    private TreeNode buildBalancedBST(ArrayList<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = buildBalancedBST(nums, start, mid - 1);
        node.right = buildBalancedBST(nums, mid + 1, end);
        return node;
    }

    // AVL rotations (if needed)
    public TreeNode insert(TreeNode node, int value) {
        if(node == null){
            return new TreeNode(value);
        }

        if(value < node.val){
            node.left = insert(node.left, value);
        } else if(value > node.val){
            node.right = insert(node.right, value);
        }

        return rotate(node); // Balance the tree after insertion
    }

    // Height function
    public int height(TreeNode node) {
        if (node == null) return 0; // Fixed height calculation
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Rotate method to balance the tree if needed
    private TreeNode rotate(TreeNode node) {
        if (node == null) return null;
        
        int balanceFactor = height(node.left) - height(node.right);

        if (balanceFactor > 1) { // Left heavy
            if (height(node.left.left) >= height(node.left.right)) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balanceFactor < -1) { // Right heavy
            if (height(node.right.right) >= height(node.right.left)) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    // AVL Rotations
    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        return y;
    }

    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        return x;
    }
}
