class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for ( int a : A ) {
            sumA += a;
        }
        for ( int b : B ) {
            sumB += b;
        }
        int target = (sumA + sumB) / 2;
        Arrays.sort(A);
        Arrays.sort(B);
        int x = 0, y = 0;
        for ( int i = 0; i < A.length; i++ ) {
            y = target - sumA + A[i];
            x = Arrays.binarySearch(B, y);
            if ( x < 0 ) continue;
            y = A[i];
            x = B[x];
            break;
        }
        return new int[]{y, x};
    }
}
