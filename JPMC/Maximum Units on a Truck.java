class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> b[1]-a[1]);

        int units=0;

        for(int i=0;i<boxTypes.length;i++){
            int numBoxes = boxTypes[i][0];
            int uBoxes = boxTypes[i][1];

            int boxesToTake = Math.min(truckSize,numBoxes);
            units += boxesToTake * uBoxes;

            truckSize -= boxesToTake;
            if(truckSize == 0) break;
            
        }
        return units;
    }
}