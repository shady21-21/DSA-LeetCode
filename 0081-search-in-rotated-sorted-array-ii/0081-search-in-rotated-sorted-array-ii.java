class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int si = 0;
        int ei = n-1;
        
        while(si<= ei){
            int mid = (si+ei)/2;
            
            if(nums[mid] == target)return true;
            //this check is for duplicates.
            if(nums[si] == nums[mid] && nums[mid] == nums[ei]){
                si ++;
                ei--;
                continue;
            }
            //check my left part is sorted or not.
            if(nums[si]<= nums[mid]){ //menas left part is sorted.
                //i search for my target.
                if(nums[si]<=target && target< nums[mid]){
                    ei = mid-1;
                }else{
                    si = mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[ei]){
                    si = mid+1;
                }else{
                    ei = mid-1;
                }
            }
        }return false;
    }
}