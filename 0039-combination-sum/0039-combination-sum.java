class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(candidates, 0, target, ans, new ArrayList<>());
    return ans;
    }

    private void backtrack(int[] arr, int index, int target, List<List<Integer>> ans, List<Integer> ds){

        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //pick
        if(arr[index] <= target){
            ds.add(arr[index]);
            backtrack(arr, index, target - arr[index], ans, ds);
            ds.remove(ds.size() - 1);
        }//not pick
        backtrack(arr, index + 1, target, ans, ds);
        
    }
}