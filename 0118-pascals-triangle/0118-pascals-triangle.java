class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        
        
        for(int row = 1; row <= numRows; row++ ){
            
            int ans = 1;
            List<Integer> eachRow = new ArrayList<>();
            eachRow.add(ans);
            
            //[1] is added
            for(int col = 1 ; col < row ; col++ ){
                ans = ans * ( row - col );
                ans = ans / (col);
                eachRow.add(ans);
            }
            pascalTriangle.add(eachRow);
        }
        return pascalTriangle;
    }
}