class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for(int num:hand){
            if(!map.containsKey(num)){
                map.put(num,1);
                arr.add(num);
            }    else{
                map.put(num,map.get(num)+1);
            }
        }
        
        for (int num : hand) {
            if (map.get(num) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = num + i;
                    if (map.getOrDefault(currentCard, 0) == 0) {
                        return false;
                    }
                    map.put(currentCard, map.get(currentCard) - 1);
                }
            }
        }

        return true;
        
    }
}