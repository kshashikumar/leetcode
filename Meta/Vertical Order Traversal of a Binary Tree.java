public class Vertical
Order Traversal
of a
Binary Tree
{
    Map<Integer,List<Pair<Integer,Integer>>> mp = new TreeMap<>();
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> q = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();

        q.add(new Pair<>(root,new Pair<>(0,0)));

        while(!q.isEmpty()){
            Pair<TreeNode,Pair<Integer,Integer>> curr = q.remove();
            int col = curr.getValue().getKey();
            int row = curr.getValue().getValue();
            TreeNode node = curr.getKey();

            if(mp.containsKey(col)){
                List<Pair<Integer,Integer>> l = mp.get(col);
                l.add(new Pair<Integer,Integer>(row,node.val));
                mp.put(col,l);
            } else {
                mp.put(col,new ArrayList<>(Arrays.asList(new Pair<Integer,Integer>(row,node.val))));
                System.out.println(mp.get(col));
            }


            if(node.left!=null){
                q.add(new Pair<>(node.left,new Pair<>(col-1,row+1)));
            } 
             if(node.right!=null){
                q.add(new Pair<>(node.right,new Pair<>(col+1,row+1)));
            }
        }

        for(List<Pair<Integer,Integer>> val: mp.values()){
            Collections.sort(val,(a,b)->{
                if(a.getKey().equals(b.getKey())){
                    return a.getValue() - b.getValue();
                } else {
                    return a.getKey() - b.getKey();
                }
            });

            List<Integer> data = new ArrayList<>();

            for(Pair<Integer,Integer> p:val){
                data.add(p.getValue());
            }
            ans.add(data);
        }

        return ans;
}
