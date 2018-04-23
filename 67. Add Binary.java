class Solution {
    public String addBinary(String a, String b) {
        if ( a.length() == 0 && b.length() == 0 ) return "0";
        if ( a.length() == 0 ) return b;
        if ( b.length() == 0 ) return a;
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int lena = stra.length - 1;
        int lenb = strb.length - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while( lena > -1 || lenb > -1){
            if (lena > -1) sum += stra[lena--] -'0';
            if (lenb > -1) sum += strb[lenb--] -'0';
            sum += carry;
            carry = sum>>1;
            int tmp = (sum & 0x1);
            sb.append(tmp);
            sum = 0;
        }
        if ( carry == 1) sb.append(1);
        return sb.reverse().toString();
        
    }
}
