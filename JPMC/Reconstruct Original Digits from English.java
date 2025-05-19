class Solution {
    public String originalDigits(String s) {
        int[] digits = new int[10];
        
        int[] count = new int[26];

        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }

        digits[0] = count['z'-'a'];
        digits[2] = count['w'-'a'];
        digits[4] = count['u'-'a'];
        digits[6] = count['x'-'a'];
        digits[8] = count['g'-'a'];

        digits[3] = count['h'-'a'] - digits[8];
        digits[5] = count['f'-'a'] - digits[4];
        digits[7] = count['s'-'a'] - digits[6];

        digits[1] = count['o'-'a'] - digits[0] - digits[2] - digits[4];
        digits[9] = count['i'-'a'] - digits[5] - digits[6] - digits[8];

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<digits.length;i++){
            while(digits[i]>0){
                sb.append(i);
                digits[i]--;
            }
        }       
        return sb.toString();


    }
}