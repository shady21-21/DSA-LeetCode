class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        //Brute Froce Approach.
        // return bruteFroce(arr, k);
        return optimalApproach(arr, k);
      
    }
    
    //Binary Search Approach
    int optimalApproach(int[]arr, int k){
        int low = 0;
        int high = arr.length-1;
        while(low<= high){
            int mid = (low+high)/2;
            int missingNum = arr[mid] - (mid+1);
            if(k>missingNum){
                //my ans on right hand side.
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low+k;
    }
    
    int bruteFroce(int[]arr, int k){
          for(int i = 0;i<arr.length;i++){
            if(arr[i]<= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
}