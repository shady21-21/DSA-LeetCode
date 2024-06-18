class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []res = new int[2];
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(mapp.containsKey(target - nums[i])){
                res[0] = mapp.get(target-nums[i]);
                res[1] = i;
            }else{
                mapp.put(nums[i], i);
            }
        }
        return res;
    }
}