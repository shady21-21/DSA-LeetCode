class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        //edge case .
        long  totalFlwneedAsBouq = (long)m*k;
        if(totalFlwneedAsBouq>bloomDay.length)return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i<bloomDay.length;i++){
            min = Math.min(bloomDay[i], min);
            max = Math.max(bloomDay[i], max);
        }
        
        int si = min;
        int ei = max;
        
        while(si<= ei){
            int mid = (si+ei)/2;
            if(isPossible(bloomDay, mid, m, k)){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return si;
    }
    
    static boolean isPossible(int[]arr, int days, int m, int k){
        int count = 0;
        int noOfBouq = 0;
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=days){
                count++;
            }else{
               noOfBouq+= count/k;
                count = 0;
            }
        }
        noOfBouq+= count/k;
        if(noOfBouq>=m){
            return true;
        }else{
            return false;
        }
    }
}