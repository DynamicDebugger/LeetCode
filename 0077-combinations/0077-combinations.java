class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtrack(1, n, k, ds, ans);
        return ans;
    }
    private void backtrack(int i, int n, int k, List<Integer> ds,List<List<Integer>> ans){
       
        if(ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(i > n){
            return;
        }
        ds.add(i);
        backtrack(i + 1, n, k, ds, ans);//i++
        ds.remove(ds.size() - 1);
        backtrack(i + 1, n, k, ds, ans);//i++
    }
}