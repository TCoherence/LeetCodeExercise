class Solution {
    public String frequencySort(String s) {
        if ( s == null || s.equals("") ) return s;
        
        // count freq
        int[] freq = new int[128];
        int maxFreq = 0;
        for ( char c : s.toCharArray() ) {
            freq[c]++;
        }
        
        // sort freq 
        List<Character>[] sortedFreq = new List[s.length() + 1];
        for ( int i = 0; i < freq.length; i++ ){
            if ( freq[i] == 0 ) continue;
            if ( sortedFreq[freq[i]] == null )
                sortedFreq[freq[i]] = new ArrayList<>();
            sortedFreq[freq[i]].add((char)i);
        }
        
        // output to StringBuilder according to sorted freq
        StringBuilder sb = new StringBuilder();
        for ( int i = sortedFreq.length - 1; i >= 0; i-- ) {
            if ( sortedFreq[i] != null ) {
                for ( char c : sortedFreq[i] ) {
                    for ( int j = 0; j < i; j++ ) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
        
    }
}
