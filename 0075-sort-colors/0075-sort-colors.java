class Solution {
    public void sortColors(int[] nums) {
        
        //this is two pointer approach.
        
        int n = nums.length;
        int si = 0;
        int ei = n-1;
        
        int k = 0; //this k is playing mej role.
        while(k<=ei){
            if(nums[k] == 0){
               
                swap(nums, k, si);
                 si++;
                 k++;
            }else if(nums[k] == 1){
                k++;
            }else{
                swap(nums, k, ei);
                ei--;
            }
        }
        
    }
    
    void swap(int[]arr, int si, int ei){
        int tem = arr[si];
        arr[si] = arr[ei];
        arr[ei] = tem;
        si++;
        ei--;
    }
}