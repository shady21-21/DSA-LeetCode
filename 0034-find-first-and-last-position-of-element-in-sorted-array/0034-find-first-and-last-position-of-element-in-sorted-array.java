class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //this question is solve using BINARY SEACH.
        int x = fistOc(0, target, nums);
        int y = lastOc(nums.length-1, target, nums);
        return new int[]{x, y};
        
    }
    
    int fistOc(int index, int target, int[]arr){
        if(index == arr.length){
            return -1;
        }
        
        if(arr[index] == target){
            return index;
        }else{
            return fistOc(index+1, target, arr);
        }
    }
    
    //for the last occurance.
    int lastOc(int index, int target, int[]arr){
        if(index == -1){
            return -1;
        }
        
        if(arr[index] == target){
            return index;
        }else{
            return lastOc(index-1, target, arr);
        }
    }
    
    
}