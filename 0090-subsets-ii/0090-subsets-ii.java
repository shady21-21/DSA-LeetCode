class Solution {
    
    //my approach -> 
    // 1st find the all subsets , then put it into HashSet and you can get uniques subsets..
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        
        findSubSet(0, set, nums, new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
        
      }
    
    void findSubSet(int index ,Set<List<Integer>>set, int[]nums,List<Integer>ds){
        
        set.add(new ArrayList<>(ds));
        
        for(int i = index;i<nums.length;i++){
            ds.add(nums[i]);
            findSubSet(i+1, set, nums, ds);
            ds.remove(ds.size()-1);
        }
    }
}