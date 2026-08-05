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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int highestDepth = 1;
        int currDepth = 1;
        while(!queue.isEmpty()){
            int nodes = queue.size();
            for(int i = 0; i < nodes; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null && currDepth > highestDepth){
                    highestDepth = currDepth;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            currDepth++;
        }
        return highestDepth;
    }
}
