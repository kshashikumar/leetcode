/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {


    // In this we have to use BFS traversal using queue to find the level order, while storing the nodes into queue, store the column numbers and treenode, when going to left it is do column-1 and to right do column+1, as well as use a map to store columns mapped to values in that column.

    public void calVO(int col,Map<Integer,List<Integer>> mp, TreeNode root){
        if(root == null) return ;

        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root,col));
        

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer> ele = q.poll();
                root = ele.getKey();
                col = ele.getValue();
                //System.out.println(col+" "+root.val);
                if(!mp.containsKey(col)){
                    mp.put(col,new ArrayList<>());
                }
                mp.get(col).add(root.val);
                if(ele.getKey().left != null){
                    q.offer(new Pair<>(root.left,Integer.valueOf(col-1)));
                }
                if(ele.getKey().right!=null){
                    q.offer(new Pair<>(root.right,Integer.valueOf(col+1)));
                }
            }
            col++;
            System.out.println(" ");
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        int col =0;
        Map<Integer,List<Integer>> mp =new TreeMap<>();
        calVO(col,mp,root);

        List<List<Integer>> ans = new ArrayList<>();
        for(Integer i: mp.keySet()){
            ans.add(mp.get(i));
        }
        return ans;
    }
}