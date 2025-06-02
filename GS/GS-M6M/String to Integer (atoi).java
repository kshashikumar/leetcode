class Solution {
    public int myAtoi(String s) {
        int i=0, n = s.length(), sign =1;

        while(i<n && s.charAt(i) == ' '){
            i++;
        }


        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = (s.charAt(i) == '-')? -1: 1;
            i++;
        }
        long ans =0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int t = s.charAt(i) - '0';

            ans =  ans*10 +t;

            if(sign * ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int) ans * sign;
    }
}