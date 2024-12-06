class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 1;i<= n ;i++){
            set.add(i);
        }
        
        //remove those who are in banned array.
        for(int xx : banned){
            set.remove(xx);
        }
        // System.out.println("SET :- " + set);
    
        int cnt = 0;
        int currSum = 0;
        for(Integer xxx : set){
            if(currSum + xxx <= maxSum){
                currSum+= xxx;
                cnt++;
            }
        }
        return cnt;
    }
}