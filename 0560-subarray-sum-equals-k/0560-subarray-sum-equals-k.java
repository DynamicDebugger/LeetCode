class Solution {
    public int subarraySum(int[] a, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        // sum -> index

        int sum = 0, count = 0;
        for(int i = 0 ; i < a.length ; i++){
            sum += a[i];
            if(sum == k){
                count++;
            }

            int rem = sum - k;
            if(preSumMap.containsKey(rem)) count+= preSumMap.get(rem);

            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        return count;           
    }
}