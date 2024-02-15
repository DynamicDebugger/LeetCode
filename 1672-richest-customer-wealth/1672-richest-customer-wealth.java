class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int maxWealth = 0;
        
        for(int[] person: accounts ){
            
            int personWealth = 0;
            
            for(int bank : person){
                personWealth += bank ;
            }
            
            //check and update max wealth
            if( personWealth > maxWealth )
                maxWealth = personWealth ; 
        }
        
        return maxWealth;
    }
    //= 0 ; person < accounts.length ; person++
    //= 0 ; bank < accounts[person].length ; bank++ 
    
}