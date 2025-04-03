class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int cntOne = 0;
        int maxOne = 0;
        for(int xx : nums){
            if(xx == 1){
               cntOne++; 
               maxOne = Math.max(maxOne, cntOne);
            }else{
                cntOne = 0;
            }
        }
        return maxOne;
    }
}