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
    int maxDiameter = 0; // Global variable to track the largest diameter found

    public int diameterOfBinaryTree(TreeNode root) {
        height(root); // Call helper function to compute height and update diameter
        return maxDiameter; // Return the final diameter
    }

    private int height(TreeNode node) {
        // Base case: empty tree has height 0
        if (node == null) return 0;

        // Recursively find height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update diameter if path through this node is longer than current max
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of this subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
