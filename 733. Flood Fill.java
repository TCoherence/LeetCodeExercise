class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if ( image == null || image.length == 0 || image[0].length == 0 ) return null;
        if ( sr < 0 || sc < 0 | sr >= image.length || sc >= image[0].length ) return null;
        helper(image, sr, sc, image[sr][sc]);
        for ( int i = 0; i < image.length; i++ ) {
            for ( int j = 0; j < image[0].length; j++ ) {
                if ( image[i][j] < 0 ) 
                    image[i][j] = newColor;
            }
        }
        return image;
    }
    public void helper(int[][] image, int sr, int sc, int prevValue) {
        if ( image == null || image.length == 0 || image[0].length == 0 ) return ;
        if ( sr < 0 || sc < 0 | sr >= image.length || sc >= image[0].length ) return ;
        if ( image[sr][sc] < 0 || image[sr][sc] != prevValue ) return;
        
        image[sr][sc] = -1;
        helper(image, sr + 1, sc, prevValue);
        helper(image, sr, sc + 1, prevValue);
        helper(image, sr - 1, sc, prevValue);
        helper(image, sr, sc - 1, prevValue);
    }
}
