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
    static int ans;
    public static void generate(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            sum <<= 1;
            sum |= root.val;
            ans += sum;
            return;
        }
        if(root.left != null) generate(root.left, sum << 1 | root.val);
        if(root.right != null) generate(root.right, sum << 1 | root.val);
    }
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        generate(root, 0);
        return ans;
    }
}