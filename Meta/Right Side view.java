public class Right
Side view
{
    

// perform the bfs search, use queue and add values to it and iterate over each value in queue like level order and add the last value to result 

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode t = q.remove();

                if (i == qSize - 1) {
                    ans.add(t.val);
                }
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }

        }

        return ans;
    }
}
