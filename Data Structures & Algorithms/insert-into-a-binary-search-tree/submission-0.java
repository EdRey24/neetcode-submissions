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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > val){
                prev = curr;
                curr = curr.left;
            }else{
                prev = curr;
                curr = curr.right;
            }
        }
        TreeNode newNode = new TreeNode(val);
        if(prev.val > val){
            prev.left = newNode;
        }else{
            prev.right = newNode;
        }
        return root;
    }
}