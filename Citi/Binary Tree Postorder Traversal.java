public class Binary
Tree Postorder Traversal
{

    public void Helper(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        Helper(root.left, ans);
        Helper(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Helper(root, ans);
        return ans;
    }
}
