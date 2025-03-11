package Citi;

public class Binary
Tree Level
Order Traversal
{
    // Initialize queue and add root to it. Then iterate over queue and add left and right nodes to queue and then add the list to ans
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode temp = q.remove();
                l.add(temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            ans.add(l);
        }
        return ans;
    }
}
