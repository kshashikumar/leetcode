public class Sum
Root to
Leaf Numbers
{
    // traverse the tree in dfs and update the currsum with latest node value and if leaf node found return the currsum
    public int findSum(TreeNode root, int currsum) {
        if (root == null)
            return 0;
        currsum = currsum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currsum;
        }
        return findSum(root.left, currsum) + findSum(root.right, currsum);
    }

    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }
}
