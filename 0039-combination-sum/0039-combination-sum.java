class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        helper(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }
    
   static void helper(int[]arr, int index, int target,List<List<Integer>>list, List<Integer>ds){
       
       //base case 
       if(index == arr.length){
           if(target == 0){
               list.add(new ArrayList<>(ds));
           }
           return;
       }
       //when we pick.
       if(target>=arr[index]){
           ds.add(arr[index]);
           helper(arr, index, target - arr[index], list, ds);
           ds.remove(ds.size()-1);
       }
       //non -pick condition
       helper(arr, index+1, target, list, ds); 
   }
}