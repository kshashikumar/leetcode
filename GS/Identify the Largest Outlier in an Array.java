public class Identify the Largest Outlier in an Array {
    public int getLargestOutlier(int[] nums) {
        int mxOutlier =Integer.MIN_VALUE,sum=0;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }

        for(Integer x:nums){
            int y = sum - 2 * x;
            if(y == x){
                if(freq.get(x)>=2){
                    mxOutlier = Math.max(mxOutlier,x);
                }
            } else if(freq.containsKey(y)){
                if(sum - x - y == x){
                    mxOutlier = Math.max(mxOutlier,y);
                } else if(sum - x - y == y){
                    mxOutlier = Math.max(mxOutlier,x);
                }
            }
        }

        return mxOutlier;
    }
}
