class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        String sign = ( numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        sb.append(sign);

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        long remainder = num%den;
        sb.append(num/den);

        if(remainder == 0 ){
            return sb.toString();
        }

        sb.append(".");

        Map<Long,Integer> mp = new HashMap<>();

        while(!mp.containsKey(remainder)){
            mp.put(remainder,sb.length());
            sb.append(10*remainder/den);
            remainder = 10*remainder%den;
        }

        int r = mp.get(remainder);
        sb.insert(r,"(");
        sb.append(")");
        return sb.toString().replace("(0)","");
    }
}