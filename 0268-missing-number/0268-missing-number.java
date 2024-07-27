class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        
        
        //first i've to be cal the nth sum of the array.
        int nthSum = n * (n+1)/2;
        
        
        //this my actual sum.
        int sum = 0;
        for(int i: nums){
            sum+= i;
        }
        return nthSum - sum;
    }
}