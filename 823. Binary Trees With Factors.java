class Solution {
    
    
    public int numFactoredBinaryTrees(int[] A) {
        long sum = 0, MOD = (long)(Math.pow(10, 9) + 7);
        Arrays.sort(A);
        // System.out.printf("A = %s\n", Arrays.toString(A));
        HashMap<Integer, Long> map = new HashMap<>();
        for ( int i = 0; i < A.length; i++ ) {
            map.put(A[i], 1l);
        }
        for ( int i = 1; i < A.length; i++ ) {
            for ( int j = i - 1; j >= 0; j-- ) {
                if ( A[i] % A[j] != 0 ) continue;
                int factor = A[i] / A[j];
                // if ( i == A.length - 1 ) {
                //     System.out.printf("F[i] = %d, A[j] = %d, factor = %d\n",map.get(A[i]), A[j], factor);
                // }
                if ( map.containsKey(factor) ) {
                    map.put ( A[i], map.get(A[i]) + map.get(A[j]) * map.get(factor) );
                }
                
            }
        }
        // System.out.println("");
        // System.out.printf("F = [");
        for ( int i = 0; i < A.length; i++ ) {
            sum += map.get(A[i]);
            // System.out.printf("%d, ",map.get(A[i]));
        }
        // System.out.println("");
        return (int)(sum % MOD);
    }
}
