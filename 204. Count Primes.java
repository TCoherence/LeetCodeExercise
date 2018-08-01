class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        for ( int i = 0; i <= n; i++ ){
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++){
            if ( prime[i] )
                for ( int j = 2; j * i < n; j++){
                    prime[j * i] = false;
                }
        }
        int cnt = 0;
        for ( int i = 2; i < n; i++){
            if ( prime[i] ) cnt++;
        }
        return cnt;
    }
}
