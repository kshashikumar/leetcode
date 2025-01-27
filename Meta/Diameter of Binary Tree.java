public class Diameter
of Binary Tree
{
    private int ans = 0;

    // recursively make a call to the internal nodes and then find left and right
    // subtree lengths, find the max of result and left+right update the result.
    // dont forget to return max (l,r)+1, as it recursively builds the height of
    // that subtree
    public int calMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = calMax(root.left);
        int r = calMax(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calMax(root);
        return ans;
    }
}
