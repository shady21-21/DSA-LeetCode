class Solution {
    public int majorityElement(int[] nums) {
       
        HashMap<Integer, Integer> map = new HashMap<>();
        //add ele with their frequecy .
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        int n = nums.length;
        
        for(Integer ele : map.keySet()){
            if(map.get(ele) > n/2){
                return ele;
            }
        }
        return -1;
    }
}