class Solution {

    public void swap(char[] chArr,int i,int j){
        char t = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = t;
    }
    public String getSmallestString(String s) {
        char[] chArr = s.toCharArray();
        String ans = s;

        for(int i=0;i<chArr.length-1;i++){
            if((chArr[i] - '0')%2 == (chArr[i+1] - '0')%2){
                swap(chArr,i,i+1);
                String temp = new String(chArr);

                if(temp.compareTo(ans)<0){
                    ans = temp;
                }
                swap(chArr,i,i+1);
            }
        }
        return ans;

    }
}