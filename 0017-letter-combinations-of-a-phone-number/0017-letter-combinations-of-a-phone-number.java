class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();

        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));

        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        String ans = "";
        solve(0, digits, ans, map, res);
        return res;

    }

    private void solve(int ind, String digits, String ans, Map<Character, List<String>> map, List<String> res){

        //base case
        if(ind == digits.length()){
            res.add(ans);
            return;
        }

        List<String> eq = map.get(digits.charAt(ind));
        for(int i = 0 ; i < eq.size() ; i++){
            solve(ind + 1, digits, ans + eq.get(i), map, res);
        }
    }
}