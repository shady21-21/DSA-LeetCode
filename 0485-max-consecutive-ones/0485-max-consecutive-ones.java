class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int ans = Integer.MIN_VALUE;
        for(int i: nums){
            if(i == 1){
                cnt++;
            }else{
                cnt = 0;
            }
           ans = Math.max(ans, cnt); 
        }
        return ans;
    }
}