class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}