class Solution {
    public int minimumSwap(String s1, String s2) {
        int xyCount = 0;
        int yxCount =0;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == 'x' && s2.charAt(i) == 'y' ){
                xyCount++;
            } else if(s1.charAt(i) == 'y' && s2.charAt(i) == 'x'){
                yxCount++;
            }
        }

        int tot = xyCount + yxCount;
        if(tot%2 !=0) return -1;

        return (xyCount/2) + (yxCount/2) + 2 * (xyCount%2);
    }
}