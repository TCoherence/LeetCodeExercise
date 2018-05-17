class Solution {
    public int addDigits(int num) {
        if ( num == 0 ) return 0;
        return (num % 9 == 0 ) ? 9 : num % 9;
    }
}

// Brilliant %9
// ab%9%9%9%9 = ab % 9
