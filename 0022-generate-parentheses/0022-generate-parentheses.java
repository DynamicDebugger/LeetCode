class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        Stack<String> ds = new Stack<>();
        backtrack(0, 0, n, ds, ls);
        return ls;

    }
    private void backtrack(int openN, int closeN, int n, Stack<String> ds, List<String> ls){
        if(openN == n && closeN == n){
            //put the stack in list
            ls.add(String.join("",ds));
            return;
        }

        if(openN < n){
            ds.add("(");
            backtrack(openN + 1, closeN, n, ds, ls);
            ds.pop();
        }
        if(closeN < openN){
            ds.add(")");
            backtrack(openN, closeN + 1, n, ds, ls);
            ds.pop();
        }
    }
}