class Solution {

    public void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(nums,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }
}