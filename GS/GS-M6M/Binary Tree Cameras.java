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
    public int cam;
    public Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;

        covered = new HashSet<>();
        cam =0;
        covered.add(null);

        dfs(null,root);
        return cam;
    }

    public void dfs(TreeNode parent, TreeNode node){
        if(node != null){
            dfs(node, node.left);
            dfs(node,node.right);

            if( (parent == null && !covered.contains(node)) || (!covered.contains(node.left) || !covered.contains(node.right))){
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
                cam++;
            }

        }
    }

}