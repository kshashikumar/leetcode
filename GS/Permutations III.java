public class Permutations III {


    //optimal way to do it
    public void calPerms(int n, List<Integer> temp,boolean[] used,List<int[]> ans){
        if(temp.size()  == n){
            ans.add(temp.stream().mapToInt(i -> i).toArray());
            return;
        }

        for(int i=1;i<=n;i++){
            if(used[i]) continue;
            if(temp.size() == 0 || (temp.get(temp.size()-1) %2 != i%2) ){
                used[i] = true;
                temp.add(i);
                calPerms(n,temp,used,ans);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }
   


    public int[][] permute(int n) {
        List<int[]> ans = new ArrayList<>();

        calPerms(n, new ArrayList<>(), new boolean[n+1],ans);

        ans.sort((a,b) -> {
            for(int i=0;i<a.length;i++){
                if(!(a[i] != b[i])){
                    return a[i] - b[i];
                }
            }
            return 0;
        });

        return ans.toArray(new int[ans.size()][]);
    }




    // traditional aaproach
    public void swap(List<Integer> list,int a,int b){
        int t = list.get(a);
        list.set(a,list.get(b));
        list.set(b,t);
    }
    public void calPerms(List<Integer> vals,List<List<Integer>> ans,int st,int ed){
        if(st == ed){
            ans.add(new ArrayList<>(vals));
            return;
        }
        for(int i=st;i<ed;i++){
            swap(vals,i,st);
            calPerms(vals,ans,st+1,ed);
            swap(vals,i,st);
        }
    }
    
    public boolean isAltering(List<Integer> perm){
        for(int i=1;i<perm.size();i++){
            if(perm.get(i) %2 == perm.get(i-1)%2){
                return false;
            }
        }
        return true;
    }


    public int[][] permute(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();

        for(int i=1;i<=n;i++){
            vals.add(i);
        }

        calPerms(vals,ans,0,n);

        ans.sort((a,b) -> {
            for(int i=0;i<a.size();i++){
                if(!a.get(i).equals(b.get(i))){
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        List<int[]> result = new ArrayList<>();

        for (List<Integer> perm : ans) {
            if(isAltering(perm)){
                int[] arr = perm.stream().mapToInt(i -> i).toArray();
                result.add(arr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
