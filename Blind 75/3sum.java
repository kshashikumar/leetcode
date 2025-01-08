import java.util.*;
class Solution {
    public List<List<Integer>> foo(int[] nums,int p,int st, int n){
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=st;i<n;i++){
            List<Integer> a = new ArrayList<>();
            int x = p -nums[i];
            if(mp.containsKey(x)){
                a.add(x);
                a.add(-p);
                a.add(nums[i]);
            } else {
                mp.put(nums[i],1);
            }
            if(a.size()>0){
                ans.add(a);
            }

        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> ignore = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            ans.addAll(foo(nums,-nums[i],i+1,nums.length));
        }
        List<List<Integer>> o = new ArrayList<>();
        o.addAll(ans);
        return o;
    }
}