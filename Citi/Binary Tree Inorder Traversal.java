public class Binary
Tree Inorder Traversal
{

    public void Helper(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        Helper(root.left, ans);
        ans.add(root.val);
        Helper(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Helper(root, ans);
        return ans;
    }
}
