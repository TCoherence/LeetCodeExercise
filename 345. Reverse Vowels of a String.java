class Solution {
    public String reverseVowels(String s) {
        // check param
        if ( s == null || s.equals("") ) return s;
        
        int l = 0;
        int r = s.length() - 1;
        char[] str = s.toCharArray();
        while ( l < r ) {
            while ( l < r && !isVowel(str[l]) ) l++;
            while ( l < r && !isVowel(str[r]) ) r--;
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(str);
    }
    public boolean isVowel(char letter) {
        if (  letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
              letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' )
            return true;
        else 
            return false;
    }
}
