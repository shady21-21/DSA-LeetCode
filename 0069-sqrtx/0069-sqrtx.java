class Solution {
    public int mySqrt(int x) {
        
        
        
        int si = 0;
        int ei = x;
        long ans = 0;
        
        while(si<=ei){
            int mid = si+(ei-si)/2;
            long val  = (long)mid * (long)mid;
            if(val<=x){
                ans = mid;
                si = mid+1;
            }else{
                ei = mid-1;
            }
            
        }
         return (int)ans;   
    }
}