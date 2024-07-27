class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k%n;
       
        //Fist rev the whole sh..
        reverse(nums, 0, n-1); 
        reverse(nums, 0, k-1); //then 0 - k-1 index
        reverse(nums,k, n-1); // again k to n-1 index.
        
    }
    
    void reverse(int[]arr, int si , int ei){
        
        while(si<= ei){
            int tem = arr[si];
            arr[si] = arr[ei];
            arr[ei] = tem;
            si++;
            ei--;
        }
    }
}