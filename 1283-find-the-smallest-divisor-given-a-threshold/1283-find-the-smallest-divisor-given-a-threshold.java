class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
       //edge case.
        if(nums.length>threshold)return -1;
        int si = 1;
        int ei = FindMax(nums);
        
        while(si<= ei){
            int mid = (si+ei)/2;
            
            if(calDiv(nums, mid)<=threshold){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return si;
    }
    static int FindMax(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }
    
    static int calDiv(int[]arr, int div){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum+= Math.ceil((double)arr[i]/(double)div);
        }
        return sum;
    }
}