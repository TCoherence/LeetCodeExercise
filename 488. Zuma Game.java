class Solution {
     private int MAX_COUNT = 6; // key
    
    public int findMinStep(String board, String hand) {
        int[] handNum = new int[26];
        for ( char c : hand.toCharArray() ) {
            handNum[c - 'A']++;
        }
        int res = deeper(board + '#', handNum); // + '#' is brilliant...
        return res == MAX_COUNT ? -1 : res;
        
    }
    public int deeper(String s, int[] nums) {
        // System.out.printf("s = %s\n", s);
        s = deleteConsecutive(s);
        // System.out.printf("s = %s\n", s);
        if ( s.equals("#") ) 
            return 0;
        int res = MAX_COUNT;
        for ( int i = 0, j = 0; j < s.length(); j++ ) {
            if ( s.charAt(i) == s.charAt(j) ) continue;
            int ballNeed = 3 - j + i;
            if (nums[s.charAt(i) - 'A'] >= ballNeed ) {
                nums[s.charAt(i) - 'A'] -= ballNeed;
                res = Math.min( res, ballNeed + deeper(s.substring(0, i) + s.substring(j), nums) );
                nums[s.charAt(i) - 'A'] += ballNeed;
            }
            i = j;
        }
        // System.out.printf("res = %d, s = %s\n", res, s);
        return res;
    }
    public String deleteConsecutive(String s) {
        int i = 0, j = 0;
        for ( ; j < s.length(); j++ ) {
            if ( s.charAt(i) == s.charAt(j) ) continue;
            if ( j - i >= 3 )
                return deleteConsecutive( s.substring(0, i) + s.substring(j) );
            i = j;
        }
        return s;
    }
}
