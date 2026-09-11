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
    // dfs
    // recursive, return int
    // remember max val so far in path
    // if current node is good, return 1 + dfs(left, x, max) + dfs(right, x, max)
    // else return dfs(left, x, max) + dfs(right, x, max)
    // return 0 if node is null
    public int goodNodes(TreeNode root) {
        // root is always good
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        // if current node is good, +1 and update max
        if (node.val >= max) {
            System.out.println(node.val);
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        }

        return dfs(node.left, max) + dfs(node.right, max);
    }
}
