class Solution {
    public int thirdMax(int[] nums) {
      Set<Long> s = new TreeSet<>(Collections.reverseOrder());

      for(int i=0;i<nums.length;i++){
        s.add((long)nums[i]);
      }

        List<Long> values = new ArrayList<>(s);

        return values.size() >=3 ? values.get(2).intValue(): values.get(0).intValue(); 

    }
}