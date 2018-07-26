class Solution {
    public String crackSafe(int n, int k) {
        int targetLen = (int) Math.pow(k, n) + n - 1;
        // System.out.printf("targetLen = %d\n", targetLen);
        StringBuilder res = new StringBuilder();
        // StringBuilder cur = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        
        for ( int i = 0; i < n; i++ ) {
            // cur.append(0);
            res.append(0);
        }
        set.add(res.toString());
        dfs(res, set, targetLen, n, k);
        
        return res.toString();
    }
    
    public boolean dfs(StringBuilder res, Set<String> set, int targetLen, int n, int k) {
        //System.out.printf("cur = %s, res = %s, len = %d\n", cur.toString(), res.toString(), set.size());
        
        if ( set.size() + n - 1 == targetLen ) {
            return true;
        }
        
        for ( int i = 0; i < k; i++ ) {
            String str = res.substring(res.length() - n + 1, res.length()) + i;
            if ( set.contains(str) ) 
                continue;
            else {
                set.add(str);
                res.append(i);
                if ( dfs(res, set, targetLen, n, k) ) return true;
                res.deleteCharAt(res.length() - 1);
                set.remove(str);
            }
        }
        return false;
    }
}
