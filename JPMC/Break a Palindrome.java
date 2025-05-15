class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";

        char[] chArr = palindrome.toCharArray();
        for(int i=0;i<n/2;i++){
            if(chArr[i] != 'a'){
                chArr[i] = 'a';
                return new String(chArr);
            }
        }

        chArr[n-1] = 'b';
        return new String(chArr);
    }
}