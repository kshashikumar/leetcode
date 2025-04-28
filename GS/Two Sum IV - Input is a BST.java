public class Two Sum IV - Input is a BST {
    public boolean findT(TreeNode root, Set<Integer> s, int k){
        if(root == null){
            return false;
        }

        if(s.contains(k - root.val)){
            return true;
        }

        s.add(root.val);

        return findT(root.left,s,k) || findT(root.right,s,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();

        return findT(root,s,k);
    }
}
