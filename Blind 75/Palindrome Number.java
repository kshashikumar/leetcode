class Solution {
    public boolean isPalindrome(int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(x<0){
            return false;
        }
        while(x!=0){
            int t = x%10;
            arr.add(t);
            x=x/10;
        }
        int l=0,r=arr.size()-1;
        while(l<=r){
            if(arr.get(l) == arr.get(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}