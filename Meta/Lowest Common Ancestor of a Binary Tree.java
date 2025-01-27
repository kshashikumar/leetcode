// recursive approach to find the lowest common ancestor, but checking the values of left and right subtrees
class Solution {

    // recursive approach to find the lowest common ancestor, but checking the
    // values of left and right subtrees
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}

// Comparing path arrays to find the lowest common ancestor
public class Lowest
Common Ancestor
of a
Binary Tree
{
     // In this approach we will find the paths of two nodes from root and use arraylist to store and then we will compare the list values to get the last common node between two paths  
    public boolean calPath(TreeNode root, List<Integer> p, int target) {
        if (root == null) {
            return false;
        }
        p.add(root.val);
        if (root.val == target) {
            return true;
        }

        if (calPath(root.left, p, target) || calPath(root.right, p, target)) {
            return true;
        }

        p.remove(p.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();

        calPath(root, p1, p.val);
        calPath(root, p2, q.val);

        int i = 0;
        while (i < p1.size() && i < p2.size() && p1.get(i) == p2.get(i)) {
            i++;
        }

        return i > 0 ? new TreeNode(p1.get(i - 1)) : null;
    }
}
