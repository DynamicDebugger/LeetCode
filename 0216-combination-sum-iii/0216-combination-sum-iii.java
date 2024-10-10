class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtrack(1, k, n , res, ds);
        return res;
    }
    private void backtrack(int index, int k , int n, List<List<Integer>> res, List<Integer> ds){
        if(ds.size() == k){
            if(n == 0)
                res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index ; i <= 9 ; i++){
            if(i <= n){
                ds.add(i);
                backtrack(i + 1, k, n - i, res, ds);
                ds.remove(ds.size() - 1);
            }
        }        
    }
}