class Solution {
    public void findSums(int[] candidates,List<List<Integer>> ans,List<Integer> temp,int start,int target){
            if(target<0){
                return;
            } else if(target == 0){
                ans.add(new ArrayList<>(temp));
            } else {
                 for(int i=start;i<candidates.length;i++){
                    temp.add(candidates[i]);
                    findSums(candidates,ans,temp,i,target - candidates[i]);
                    temp.remove(temp.size()-1);
                }
            }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findSums(candidates,ans,temp,0,target);

        return ans;
    }
}