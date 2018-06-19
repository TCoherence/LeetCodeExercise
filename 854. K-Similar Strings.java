class Solution {
    public int kSimilarity(String A, String B) {
        if ( A.equals(B) ) return 0;
        Set<String> status = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        status.add(A);
        //status.add(B);
        queue.add(A);
        int res = 0;
        while ( !queue.isEmpty() ){
            res++;
            for (int sz = queue.size(); sz > 0; sz--){  //  In this way can we avoid sz boundry to change, because if we write the code like 
                                                        //  int sz = 0; sz < queue.size(); sz++, it looks like no problem BUT queue.size will 
                                                        //  keep changing so the code is not doing what we want.
                String s = queue.poll();
                int len = s.length();
                int i = 0; 
                while (s.charAt(i) == B.charAt(i)) i++;
                for (int j = i+1; j < len; j++){
                    if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) continue;
                    String str = swap(s, i, j);
                    if (str.equals(B)) return res;
                    if (status.add(str)) queue.add(str);
                }
            }
        
        }
        return res;
    }
    public String swap( String str, int i, int j){
        char[] s = str.toCharArray();
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        // return String.valueOf(s);
        return new String(s);
    }
}
