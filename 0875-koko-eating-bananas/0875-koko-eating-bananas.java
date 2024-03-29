class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        //find out how many banana koko eat/hr
        // min banana koko eat per hr is 1banana/hr.
        //max she eat Max(element in the array)
        
        int si = 1;
        int ei = max(piles);
        
        while(si<= ei){
            int mid = (si+ei)/2;
            
            int totalTime = calTime(piles,mid);
            if(totalTime<= h){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return si;
    }
    
    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }
    
    static int calTime(int[]arr, int hr){
        int totalTime = 0;
        for(int i = 0;i<arr.length;i++){
            totalTime+= Math.ceil((double)arr[i]/(double)hr);
        }
        return totalTime;
    }
}