class Solution {
    public boolean isPowerOfFour(int num) {
        // condition one : num > 0
        boolean condition_1 = num > 0;
        // condition two : the power of 4 only contains one bit '1' but not only the power of 4 contains only one bit '1'
        boolean condition_2 = (num & ( num - 1 )) == 0;
        // condition three : num - 1 % 3 == 0
        boolean condition_3 = ( num - 1 ) % 3 == 0;
        return condition_1 && condition_2 && condition_3;
    }
}
