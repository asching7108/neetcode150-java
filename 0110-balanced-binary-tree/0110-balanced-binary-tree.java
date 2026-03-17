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

class TreeInfo {
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).balanced;
    }

    private TreeInfo isBalancedHelper(TreeNode root) {
        // An empty tree is balanced and has height -1
        if (root == null) return new TreeInfo(-1, true);

        // Check subtrees
        TreeInfo left = isBalancedHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(0, false);
        }

        TreeInfo right = isBalancedHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(0, false);
        }

        return new TreeInfo(
            Math.max(left.height, right.height) + 1,
            Math.abs(left.height - right.height) < 2
        );
    }
}