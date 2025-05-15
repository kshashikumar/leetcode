class Solution {
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for(int i=1;i<arr.length;i++){
            int diff = arr[i]-arr[i-1];
            if(minDiff > diff){
                minDiff = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            } else if( diff == minDiff){
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
       return ans;
    }
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Map<Integer,List<List<Integer>>> mp = new TreeMap<>((a,b) -> a - b);

        Arrays.sort(arr);

        for(int i=1;i<arr.length;i++){
            if(!mp.containsKey(arr[i]-arr[i-1])){
                mp.put(arr[i]-arr[i-1],new ArrayList<>());
            }
            mp.get(arr[i]-arr[i-1]).add(Arrays.asList(arr[i-1],arr[i]));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Integer t : mp.keySet()){
            ans = mp.get(t);
            break;
        }

        return ans;
    }

    
}