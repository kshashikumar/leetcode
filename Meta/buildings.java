public class buildings-with-an-ocean-view
{
    // Iterate from last and keep the max element updated and include values that are greater than max into ans
    public int[] findBuildings(int[] heights) {
        List<Integer> ans = new ArrayList<>();
        int mx = 0;

        for(int i=heights.length-1; i>=0;i--){
                if(heights[i] > mx){
                    mx = heights[i];
                    ans.add(i);
                }
        }
        
        return ans.stream().sorted().mapToInt(a -> a).toArray();
    }
}
