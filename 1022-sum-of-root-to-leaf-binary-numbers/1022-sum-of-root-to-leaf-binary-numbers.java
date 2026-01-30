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
    public static void generateAns(TreeNode root, int val){
        if(root == null) return;
        val = (val << 1) | root.val;
        if(root.left == null && root.right == null){
            ans += val;
            return;
        }
        generateAns(root.left, val);
        generateAns(root.right, val);
    }

    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        generateAns(root, 0);
        return ans;
    }
}