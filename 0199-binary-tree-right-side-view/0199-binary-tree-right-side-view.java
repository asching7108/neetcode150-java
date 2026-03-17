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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.add(root);

        while (!curr.isEmpty()) {
            TreeNode node = curr.remove();
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
            if (curr.isEmpty()) {
                res.add(node.val);
                Queue<TreeNode> temp = curr;
                curr = next;
                next = temp;
            }
        }

        return res;
    }
}