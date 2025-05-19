class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        Arrays.fill(freq,0);
        Set<Integer> ans = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            freq[nums1[i]]++;
        }

        for(int i=0;i<nums2.length;i++){
            if(freq[nums2[i]] >0){
                ans.add(nums2[i]);
            }
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}