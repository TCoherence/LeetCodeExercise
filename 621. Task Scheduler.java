class Solution {
    public int leastInterval(char[] tasks, int n) {
        // check para
        if ( tasks == null || tasks.length == 0 || n < 0 ) return 0;
        
        // two conditions:
        // 1. n is larger or equal to tasks's types
        // 2. n is smaller than tasks's types
        int maxFreq = 0, maxFreqNum = 0;
        int[] character = new int[26];
        for ( char task : tasks ) {
            int index = task - 'A';
            character[index]++;
            maxFreq = Math.max(maxFreq, character[index]);
        }
        
        // find maxFreqNum
        for ( int i = 0; i < character.length; i++ ) {
            if ( character[i] == maxFreq ) 
                maxFreqNum++;
        }
        
        // return
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxFreqNum);
    }
}
