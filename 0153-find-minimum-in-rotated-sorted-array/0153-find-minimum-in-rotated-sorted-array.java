class Solution {
    public int findMin(int[] nums) {
        
        int min = 5000 ;
        int n = nums.length;
        
        int si = 0;
        int ei = n-1;
        
        while(si<= ei){
            int mid = (si+ei)/2;
            
            //if my whole array is sorted from si to ei then si will be ans always.
            if(nums[si]<= nums[ei]){
                min = Math.min(min, nums[si]);
                break; //no need to iteration.
            }
            
            // what happen if my left portion is sorted.
            if(nums[si]<= nums[mid]){
                min = Math.min(min, nums[si]);
                si = mid+1;
            }else{
                ei = mid-1;
                min = Math.min(min, nums[mid]);
            }
        }
        return min;
    }
}