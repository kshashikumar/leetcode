class Solution {

    public void calPerms(List<Integer> temp,List<int[]> ans, boolean[] used, int n){
        if(temp.size() == n){
            ans.add(temp.stream().mapToInt(i->i).toArray());
            return;
        }
        for(int i=1;i<=n;i++){
            if(used[i]) continue;
            if(temp.size() == 0 || temp.get(temp.size()-1)%2 != i%2){
                used[i] = true;
                temp.add(i);
                calPerms(temp,ans,used,n);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }

    public int[][] permute(int n) {
        List<int[]> ans = new ArrayList<>();
        boolean[] used = new boolean[n+1];

        calPerms(new ArrayList<>(),ans,used,n);

        ans.sort((a,b) -> {
            for(int i=0;i<a.length;i++){
                if(a[i] == b[i]){
                    return a[i] - b[i];
                }
            }
            return 0;
        });

        return ans.toArray(new int[ans.size()][]);

    }
}