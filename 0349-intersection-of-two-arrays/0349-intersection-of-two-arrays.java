class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
       
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i:nums1){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        
        Set<Integer> set = new HashSet<>();
        for(int ele : nums2){
            if(map.containsKey(ele)){
               set.add(ele);  
            }
        }
        
        int[]arr = new int[set.size()];
        int index = 0;
        for(Integer ele : set){
            arr[index] = ele;
            index++;
        }
        return arr;
    }
}