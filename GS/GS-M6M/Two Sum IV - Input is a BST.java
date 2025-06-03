
class Solution {

    public boolean dfs(TreeNode root, Set<Integer> s, int k){
        if(root == null) return false;

        if(s.contains(k - root.val)){
            return true;
        }

        s.add(root.val);

        return dfs(root.left,s,k) || dfs(root.right,s,k);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();

        return dfs(root,s,k);
    }
}