class Solution {
    public boolean checkIfExist(int[] arr) {
        
        Set<Integer> set = new HashSet<>();
        for(int xx : arr){
            if(set.contains(xx*2) || (xx%2 == 0 && set.contains(xx/2))){
                return true;
            }
            set.add(xx);
        }
        return false;
    }
}