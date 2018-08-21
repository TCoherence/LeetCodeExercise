class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();  // bank
        Set<String> seen = new HashSet<>(); // seen before?
        Queue<String> q = new LinkedList<>();
        char[] select = new char[]{'A', 'G', 'C', 'T'};
        int step = 0;
        
        for ( String s : bank ) {
            set.add(s);
        }
        set.add(start);
        seen.add(start);
        if ( !set.contains(end) ) return -1;
        q.offer(start);
        while ( !q.isEmpty() ) {
            int size = q.size();
            for (int i = 0; i < size; i++ ) {
                String s = q.poll();
                if ( s.equals(end) ) return step;
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++ ) {
                    char oldChar = chars[j];
                    for ( char swap : select ) {
                        chars[j] = swap;
                        String next = new String(chars);
                        if ( !seen.contains(next) && set.contains(next) ) {
                            seen.add(next);
                            q.offer(next);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
            step++;
        }
        return -1;
    }
    

}
