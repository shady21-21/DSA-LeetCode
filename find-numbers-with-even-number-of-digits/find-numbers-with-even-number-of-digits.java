class Solution {
    public int findNumbers(int[] nums) {
        
        int cntEvenDig = 0;
        
        for(int xx :nums){
            
            int NoOfDig  = cntDig(xx);
            if(NoOfDig%2 == 0){
                cntEvenDig++;
            }
        }
        return cntEvenDig;
    }
    
    
    int cntDig(int n){
        
        int cnt = 0;
        while(n>0){
            int last = n%10;
            cnt++;
            n = n/10;
        }
        return cnt;
    }
}