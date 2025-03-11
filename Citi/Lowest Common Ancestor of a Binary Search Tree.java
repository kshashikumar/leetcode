package Citi;

public class Lowest
Common Ancestor
of a
Binary Search Tree
{
    // If root is greater than both p and q, then LCA lies in left
    // If root is smaller than both p and q, then LCA lies in right
    // Else root is the LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}
