class Solution {
    // public int countArrangement(int N) {
    //     if ( N <= 1 ) return 1;
    //     int count = backtrack(1, N, new ArrayList<Integer>(), 0);
    //     return count;
    // }
    // public int backtrack(int pos, int n, List<Integer> pre, int count){
    //     if( pre.size() == n ) {
    //         count++;
    //         return count;
    //     }
    //     for ( int i = 1; i <= n; i++){
    //         if( pre.contains(i) ) continue;
    //         pre.add(i);
    //         if( i % pos == 0 || pos % i == 0 ) {
    //             count = backtrack(pos+1, n, pre, count);
    //         }
    //         pre.remove(pre.size() - 1);
    //     }
    //     return count;
    // }
    int count = 0;
    public int countArrangement(int N) {
        if ( N <= 1) return 1;
        backtrack(N, N, new boolean[N+1]);
        return count;
    }
    public void backtrack(int n, int pos, boolean[] used){
        if( pos == 0 ){
            count++;
            return;
        }
        else{
            for ( int i = 1; i <= n; i++ ) {
                if( used[i] ) continue;
                else{
                    if(i % pos == 0 || pos % i == 0){
                        used[i] = true;
                        backtrack(n, pos-1, used);
                        used[i] = false;
                    }
                }
            }
        }
    }
}
