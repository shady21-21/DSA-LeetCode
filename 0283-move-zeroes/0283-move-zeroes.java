class Solution {
    public void moveZeroes(int[] nums) {
        
        
        int i = 0;
        int j = 0;
        while(i<nums.length){
            if(nums[i] == 0){
                i++;
            }else{
                int tem = nums[j];
                nums[j] = nums[i];
                nums[i] = tem;
                i++;
                j++;
            }
        }
    }
}