class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int k = n-2;
        for(int i = n-1 ;i>0;i--){
            if(nums[i]<= nums[i-1]){
                k--;
            }else{
                break;
            }
        }
        
        // if the array is sorted then reserve it.
        if(k == -1){
            reverse(nums, 0, n-1);
            return;
        }
        
        for(int i = n-1;i>0;i--){
            if(nums[i]>nums[k]){
                //swap
                int tem = nums[k];
                nums[k] = nums[i];
                nums[i] = tem;
                break;
            }
        }
        reverse(nums, k+1, n-1);
    }
    
    static void reverse(int[]nums, int si , int ei){
        while(si<ei){
            int tem = nums[si];
            nums[si]= nums[ei];
            nums[ei] = tem;
            si++;
            ei--;
         }
    }
}