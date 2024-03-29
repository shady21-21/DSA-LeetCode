class Solution {
    public int searchInsert(int[] nums, int target) {
        int si = 0;
        int n = nums.length;
        int ei = n-1;
        
        while(si<=ei){
            int mid = (si+ei)/2;
            if(nums[mid] == target)return mid;
            if(target>nums[mid]){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return si;
    }
}