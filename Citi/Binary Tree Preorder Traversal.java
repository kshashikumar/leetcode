public class Binary
Tree Preorder Traversal
{

    public void Helper(List<Integer> ans, TreeNode node) {
        if (node == null)
            return;

        ans.add(node.val);
        Helper(ans, node.left);

        Helper(ans, node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Helper(ans, root);
        return ans;

    }
}
