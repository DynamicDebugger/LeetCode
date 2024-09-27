class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int initial = image[sr][sc];
        if(image[sr][sc] == color) return image;
        fill(sr, sc , row, col, image, initial, color);

        return image;
    }
    private void fill(int curRow, int curCol, int row, int col, int[][] image, int initial, int clr){
        if(curRow < 0 || curRow >= row || curCol < 0 || curCol >= col || image[curRow][curCol] != initial){
            return;
        }
        image[curRow][curCol] = clr;
        fill(curRow - 1, curCol, row, col, image, initial, clr);
        fill(curRow + 1, curCol, row, col, image, initial, clr);
        fill(curRow, curCol - 1, row, col, image, initial, clr);
        fill(curRow, curCol + 1, row, col, image, initial, clr);
    }
}