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
        TreeNode node = root;

        while (node != null) {
            int parentVal = node.val;

            if (p.val > parentVal && q.val > parentVal) {
                node = node.right;
            } else if (p.val < parentVal && q.val < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }

        return null;
    }
}