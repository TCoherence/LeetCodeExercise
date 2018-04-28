class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        return validhelper(s, 0, len - 1,false);
    }
    public boolean validhelper(String s, int left, int right, boolean hasDeleted){
        char[] str = s.toCharArray();
        while( left < right ){
            if( str[left] == str[right] ) {
                left++;
                right--;
                continue;
            }
            else{
                if( hasDeleted ) return false;
                else return ( validhelper(s, left+1, right, true) || validhelper(s, left, right-1, true) );
            }
        }
        return true;
    }
}
