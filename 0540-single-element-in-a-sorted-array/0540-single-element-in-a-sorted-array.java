class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        
        if(nums[0]!= nums[1])return nums[0];
        if(nums[n-1]!= nums[n-2])return nums[n-1];
        
        int si = 1;
        int ei = n-2;
        while(si<= ei){
            int mid = (si+ei)/2;
            
            //check mid left and right.
            if(nums[mid]!= nums[mid-1] && nums[mid]!= nums[mid+1])return nums[mid];
            
            //check my mid index is EVEN or ODD.
            //This is a Catch that -> if my Mid ata ODD index then left side always EVEN index.
            if(mid%2 == 1 && nums[mid] == nums[mid-1] || mid%2 == 0 && nums[mid]== nums[mid+1]){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return -1;
    }
}