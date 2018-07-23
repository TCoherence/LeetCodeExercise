class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isPositive = true;
        if ( numerator < 0 ) isPositive = !isPositive;
        if ( denominator < 0 ) isPositive = !isPositive;
        
        long num = numerator;
        long deo = denominator;
        int quotient = 0;
        int remainder = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        String intPart = String.valueOf(num / deo);
        sb.append(intPart);
        index += intPart.length();
        remainder = numerator % denominator;
        if (remainder == 0 ) return sb.toString();
        sb.append('.');
        index++;
        while ( remainder != 0 && !map.containsKey(remainder) ) {
            map.put(remainder, index++);
            num = (long)remainder * 10;
            quotient  =  (int)(num / deo);
            remainder =  (int)(num % deo);
            sb.append(Math.abs(quotient)); 
        }
        if ( remainder != 0 ) {
            sb.append(')');
            int idx = map.get(remainder);
            sb.insert(idx, (char)'(' );
        }
        if ( !isPositive && Integer.valueOf(intPart) == 0 ) sb.insert(0, (char)'-'); 
        return sb.toString();
        
        
        // return
        // return ( String.valueOf(-2147483648 % -3) );
    }
}
