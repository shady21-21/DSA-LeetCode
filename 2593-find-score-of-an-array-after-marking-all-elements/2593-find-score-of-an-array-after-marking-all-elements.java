class Solution {
    public long findScore(int[] nums) {
         
        int n = nums.length;
        long ans = 0;
        
        boolean[]vis = new boolean[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]); //get smallest 1st.
        //i push two size arr in pq [ele, index];
        for(int i = 0;i<nums.length;i++){
            pq.offer(new int[]{nums[i], i});
        }
        
        while(!pq.isEmpty()){
            int[]curr = pq.poll();
            int sm = curr[0];
            int index = curr[1];
            
            if(vis[index]){continue;} //skip that ele.
            
            
            ans+= sm;
            vis[index] = true;
            
            if(index+1 < n){
                vis[index+1] = true;
            }
            
            if (index - 1 >= 0) {
                vis[index - 1] = true;
            }
        }
        
      return ans;  
        
        
//         int n = nums.length;
//         long ans = 0;
        
//         boolean[]vis = new boolean[n];
        
//         for(int i = 0;i<n;i++){
//             int index = smallerstNumber(nums, vis);
//             // System.out.println("smallest ele index  - > " + index);
//             if(index == -1){break;}
//             ans += nums[index];
            
//             //marks current and his adj elements.
//             vis[index] = true;
//             if(index+1 < n){
//                 vis[index+1] = true;
//             }
            
//             if (index - 1 >= 0) {
//                 vis[index - 1] = true;
//             }
//         }
//         return ans;
    }
    
    // public int smallerstNumber(int[]arr, boolean[]vis){
    //     int min = Integer.MAX_VALUE;
    //     int index = -1;
    //     for(int i = 0;i<arr.length;i++){
    //         if(!vis[i] && arr[i]< min){
    //             min = arr[i];
    //             index = i;
    //         }
    //     }
    //     return index;
    // }
}