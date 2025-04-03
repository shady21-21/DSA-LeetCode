class Solution {
    public int[] sortedSquares(int[] nums) {
        
        
        
        int n = nums.length;
        int[]ans = new int[n];
        int k = 0;
        
        for(int xx : nums){
            ans[k++] = xx*xx;
        }
        Arrays.sort(ans);
        return ans;
    }
}