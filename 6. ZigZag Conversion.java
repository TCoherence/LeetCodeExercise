class Solution {
    public String convert(String s, int numRows) {
        // 旅完这个游，竟有一种劫后余生的感觉。
        if ( s == null  ) throw new java.lang.IllegalArgumentException();
        if ( s.length() == 0 ) return s;
        if ( numRows == 0 || numRows == 1 || numRows >= s.length() ) return s;
        char[] str = s.toCharArray();
        int len = str.length;
        int k = 2*numRows - 2; // loop length
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < numRows; i++){
            int left = i;
            int right = k - i;
            while(left < len) {
                sb.append(str[left]);
                left += k;
                if ( i + k == k - i || i == k - i ) continue;
                if(right < len) {
                    sb.append(str[right]);
                    right += k;
                }
            }
        }// for-loop enmd
        return sb.toString();
    }
}
