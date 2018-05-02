class Solution {
    public String multiply(String num1, String num2) {
        if( num1 == null || num2 == null ) return "";
        if( num1.length() == 0 || num2.length() == 0 ) return "";
        if( num1.equals("0") || num2.equals("0") ) return "0";
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int len1 = n1.length;
        int len2 = n2.length;
        int digit = 0;
        int carry = 0;
        int d1,d2;
        char[] res = new char[len1+len2];
        for ( int i = 0; i < len1+len2;i++){
            res[i] = '0';
        }
        for ( int i = len1 - 1; i >= 0; i-- ) {
            d1 = n1[i] - '0';
            for ( int j = len2 - 1; j >= 0; j--) {
                d2 = n2[j] - '0';
                digit = (res[i+j+1] - '0') + d1 * d2 + carry;
                carry = digit / 10;
                digit = digit % 10;
                res[i+j+1] = (char)(digit + '0');
            }
            res[i] = (char)('0' + carry);
            carry = 0;
        }
        StringBuilder sb = new StringBuilder();
        if ( res[0] != '0') sb.append(res[0]);
        for ( int i = 1; i < len1+len2; i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
