public class Dot
Product of
Two Sparse Vectors
{
        // use OOPs concepts to perform this task add getvector method and try to multiple each vectors parellaly
    private List<Integer> v = new ArrayList<>();

    SparseVector(int[] nums) {
        for(int i=0;i<nums.length;i++){
            v.add(nums[i]);
        }
    }

    public List<Integer> getVec() {
        return this.v;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        List<Integer> v2 = vec.getVec();
        if (v2.size() != this.v.size())
            return 0;

        int ans = 0;

        for (int i = 0; i < v2.size(); i++) {
            ans += (v2.get(i) * this.v.get(i));
        }

        return ans;
    }
}
