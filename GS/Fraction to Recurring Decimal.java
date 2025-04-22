package GS;

public class Fraction to Recurring Decimal {
    
    StringBuilder sb = new StringBuilder();

    String sign = (numerator < 0 == denominator < 0 || numerator ==0) ? "":"-";

    sb.append(sign);
    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);

    sb.append(num/den);

    if(num%den ==0){
        return sb.toString();
    }

    sb.append(".");

    Map<Long,Integer> mp = new HashMap<>();
    long remainder = num%den;

    while(! mp.containsKey(remainder) ){
        mp.put(remainder, sb.length());
        sb.append(10 * remainder/den);
        remainder = 10 * remainder % den;
    }

    int r = mp.get(remainder);

    sb.insert(r,"(");
    sb.append(")");

    return sb.toString().replace("(0)", "");
}
