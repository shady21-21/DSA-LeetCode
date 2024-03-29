class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        int[]res = new int[2];
        res[0] = FirstOcc(nums, target);
        res[1] = LastOcc(nums, target);
        return res;
    }
    
    static int LastOcc(int[]arr, int target){
        int n = arr.length;
        int si = 0;
        int ei = n-1;
        int LastOcc = -1;
        while(si<= ei){
            int mid = (si+ei)/2;
            if(arr[mid] == target){
                LastOcc = mid;
                si = mid+1;
            }else if(arr[mid]<target){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return LastOcc;
    }
    
     static int FirstOcc(int[]arr, int target){
        int n = arr.length;
        int si = 0;
        int ei = n-1;
        int FirstOcc = -1;
        while(si<= ei){
            int mid = (si+ei)/2;
            if(arr[mid] == target){
                FirstOcc = mid;
                ei = mid-1;
            }else if(arr[mid]<target){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }
        return FirstOcc;
    }
}