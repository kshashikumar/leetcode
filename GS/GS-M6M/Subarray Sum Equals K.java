class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();

        int sum =0,count =0;
        mp.put(0,1);
        for(int num:nums){
            sum += num;

            if(mp.containsKey(sum - k)){
                count +=mp.get(sum -k);
            }
            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}