class Solution {

    public void calSub(int[] nums,List<List<Integer>> ans,List<Integer> temp,int st, int target){
        if(target < 0){
            return;
        } else if(target == 0){
            ans.add(new ArrayList<>(temp));
            return ;
        } else {
            for(int i=st;i<nums.length;i++){
                temp.add(Integer.valueOf(nums[i]));
                calSub(nums,ans,temp,i,target-(Integer.valueOf(nums[i])));
                temp.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        calSub(candidates,ans,temp,0,target);
        return ans;
    }
}