public class Range
Sum of BST
{
    
    // iterate recursively on left and right subtress and then return the sum of values of nodes in given range
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int l = rangeSumBST(root.left, low, high);
        int r = rangeSumBST(root.right, low, high);

        return root.val >= low && root.val <= high ? root.val + (l + r) : (l + r);
    }
}
