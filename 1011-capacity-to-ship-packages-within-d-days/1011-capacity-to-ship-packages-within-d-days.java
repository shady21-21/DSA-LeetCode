class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        //lets, observed one thing  min Capacity is always be max element in the array.
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = weights.length;
        
        for(int i = 0;i<n;i++){
            max = Math.max(max, weights[i]);
            sum+= weights[i];
        }
        
        int low = max;
        int high = sum;
        while(low<= high){
            int mid = (low+high)/2;
            
            int noOfDays = findDays(weights, mid);
            if(noOfDays<= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }
    static int findDays(int[]arr, int cap){
        int load = 0;
        int day = 1;
        for(int i = 0;i<arr.length;i++){
            if(load + arr[i]>cap){
               day+=1;
               load = arr[i]; 
            }else{
                load+= arr[i];
            }
        }
        return day;
    }
}