class Solution {
    public List<String> restoreIpAddresses(String s) {
        // check para 
        if ( s == null ) return new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        helper(s, 0, s.length(), 1, sb, res);
        return res;
    }
    /* 
     * 
     * @param
     * String           s       input param from user
     * int              start   current start idx
     * int              end     equals to s.length() all the time
     * int              rank    indicate current k-th of IPv4 address
     * StringBuilder    sb      build every possible String used to be stored in res(following param)
     * List<String>     res     store every possible String
     */
    public void helper(String s, int start, int end, int rank, StringBuilder sb, List<String> res) {
        int len = 4 - rank + 1;
        if ( (end - start) < len || (end - start) > len * 3 ) return;
        if ( rank == 4 ) {
            if ( (end - start) > 1 && s.charAt(start) == '0' ) return;
            if ( Integer.valueOf(s.substring(start, end)) > 255 ) return;
            sb.append(s.substring(start, end));
            res.add(sb.toString());
            sb.delete(sb.length() + start - end, sb.length());
            return;
        }
        // 1 bit
        sb.append(s.substring(start, start + 1));
        sb.append('.');
        helper(s, start + 1, end, rank + 1, sb, res);
        sb.delete(sb.length() - 2, sb.length());
        // 2 bit
        // the next rank must have one bit at least so no need to check whether start + 2 is valid
        if ( s.charAt(start) == '0' ) return;
        sb.append(s.substring(start, start + 2));
        sb.append('.');
        helper(s, start + 2, end, rank + 1, sb, res);
        sb.delete(sb.length() - 3, sb.length());
        // 3 bit
        // need to check if > 255
        if ( s.charAt(start) == '0' ) return;
        if ( start + 3 > s.length() ) return;
        if ( Integer.valueOf(s.substring(start, start + 3)) > 255 ) return;
        sb.append(s.substring(start, start + 3));
        sb.append('.');
        helper(s, start + 3, end, rank + 1, sb, res);
        sb.delete(sb.length() - 4, sb.length());
        return;
    }
}
