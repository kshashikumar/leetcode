class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> last = new HashMap<>();

        int degree =0;
        for(int i=0;i<nums.length;i++){
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);

            degree = Math.max(degree,count.get(nums[i]));

            if(!first.containsKey(nums[i])){
                first.put(nums[i],i);
            }
            last.put(nums[i],i);
        }

        int minL = Integer.MAX_VALUE;
        for(int key:count.keySet()){
            if(count.get(key) == degree){
                minL = Math.min(minL,last.get(key) - first.get(key)+1);
            }
        }

        return minL;

    }
}