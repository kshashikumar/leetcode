class Solution {
    public int getLargestOutlier(int[] nums) {
        int mxOutlier = Integer.MIN_VALUE, sum =0;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int num : nums){
            sum +=num;
            mp.put(num, mp.getOrDefault(num,0)+1);
        }

        for(int x:nums){
            int y = sum - 2*x;
            if(y == x){
                if(mp.get(x) >= 2){
                    mxOutlier = Math.max(mxOutlier,x);
                }
            } else if(mp.containsKey(y)){
                if(sum - x - y == x){
                    mxOutlier = Math.max(mxOutlier, y);
                } else if( sum - x - y == y){
                    mxOutlier = Math.max(mxOutlier, x);
                }
            }
        }

        return mxOutlier;

    }
}