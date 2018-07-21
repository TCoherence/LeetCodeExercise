// stereotype solution from 4Sum problem, whne there are 4 array which is very clear that we can solve it in O(n^2), I still solve it in 
// O(N^3) time which is very cliche and stupid.
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // check param
        if ( A == null || B == null || C == null || D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0 ) return 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int count = 0;
        for ( int i = 0; i < A.length; i++ ) {
            for ( int j = 0; j < B.length; j++ ) {
                int l = 0;
                int r = D.length - 1;
                while ( l < C.length && r >= 0 ) {
                    int num = A[i] + B[j] + C[l] + D[r];
                    if ( num == 0 ) {
                        count++;
                        int cnt1 = 1, cnt2 = 1;
                        while ( l < C.length - 1 && C[l] == C[l + 1] ) {
                            cnt1++;;
                            l++;
                        }
                        while ( r > 0 && D[r] == D[r - 1] ) {
                            cnt2++;
                            r--;
                        }
                        count += cnt1 * cnt2 - 1;
                        l++;
                        r--;
                    }
                    else if ( num > 0 ) 
                        r--;
                    else  
                        l++;
                }
            }
        }
        return count;
    }
}

// O(N^2) solution
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // check param
        if ( A == null || B == null || C == null || D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0 ) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < A.length; i++ ) {
            for ( int j = 0; j < B.length; j++ ) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int res = 0;
        for ( int i = 0; i < C.length; i++ ) {
            for ( int j = 0; j < D.length; j++ ) {
                res += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return res;
    }
}
