class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) == '0'?0:1;

        for(int i=n-2;i>=0;i--){
            int ch = s.charAt(i) - '0';

            if(ch == 0){
                dp[i] = 0;
            } else {
                int twoDigits = Integer.parseInt(s.substring(i,i+2));
                if(twoDigits <= 26){
                    dp[i] = dp[i+1] + dp[i+2];
                } else {
                    dp[i] = dp[i+1];
                }
            }
        }
        return dp[0];
    }
}