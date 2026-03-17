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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) return levels;

        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.add(root);

        while (!curr.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while (!curr.isEmpty()) {
                TreeNode node = curr.remove();
                level.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            levels.add(level);
            Queue<TreeNode> temp = curr;
            curr = next;
            next = temp;
        }

        return levels;
    }
}