class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        //add all element with their freq.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(Integer ele : map.keySet()){
            if(map.get(ele) > n/3){
                list.add(ele);
            }
        }
        return list;
    }
}